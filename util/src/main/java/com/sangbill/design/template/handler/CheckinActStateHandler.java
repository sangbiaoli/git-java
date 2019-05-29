package com.sangbill.design.template.handler;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.sangbill.design.template.AbstactActStateHandler;
import com.sangbill.design.template.CheckinActDetailJsonVO;
import com.sangbill.design.template.enumdef.RealActState.ERealActState;
import com.sangbill.design.template.enumdef.act.CheckinActState;
import com.sangbill.util.DateUtil;

@Component
public class CheckinActStateHandler extends AbstactActStateHandler{

	
	public CheckinActStateHandler() {
		super(CheckinActState.ENUMMAP);
	}

	@Override
	public int getReleaseActState(Date startTime, Date endTime, Date enterStartTime, Date enterEndTime,
			String actDetailJson) {
		CheckinActDetailJsonVO vo = JSONObject.parseObject(actDetailJson, CheckinActDetailJsonVO.class);		
		long now = DateUtil.now().getTime();
		long day = DateUtils.truncate(DateUtil.now(), Calendar.DATE).getTime();	
		
		if (enterEndTime != null && enterEndTime.getTime() > now) {	//活动报名中
			return getState(ERealActState.ENTERING);
		} else if (vo.getActMinTime() > now) {	//活动即将开始
			return getState(ERealActState.ACTIVITY_NOT_START);
		} else if (vo.getActMinTime() <= now && vo.getActMaxTime() > now) {	//活动中
			return getState(ERealActState.ACTIVITY_HODING);
		} else if (vo.getActMaxTime() <= now) {  //活动已结束
			return getState(ERealActState.ACTIVITY_FINISHED);
		}
		return NOT_MATCH_STATE;
	}
	
}
