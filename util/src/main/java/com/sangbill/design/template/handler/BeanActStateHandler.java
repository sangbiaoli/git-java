package com.sangbill.design.template.handler;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Component;

import com.sangbill.design.template.AbstactActStateHandler;
import com.sangbill.design.template.enumdef.RealActState.ERealActState;
import com.sangbill.design.template.enumdef.act.BeanActState;
import com.sangbill.util.DateUtil;

@Component
public class BeanActStateHandler extends AbstactActStateHandler{

	
	public BeanActStateHandler() {
		super(BeanActState.ENUMMAP);
	}

	@Override
	public int getReleaseActState(Date startTime, Date endTime, Date enterStartTime, Date enterEndTime,
			String actDetailJson) {
		long now = DateUtil.now().getTime();
		long day = DateUtils.truncate(DateUtil.now(), Calendar.DATE).getTime();
		
		if (null != startTime && startTime.getTime() > day) { // 活动未开始
			return getState(ERealActState.ACTIVITY_NOT_START);
		} else if (null != startTime && startTime.getTime() <= day && (endTime == null || day <= endTime.getTime())) { // 活动中
			return getState(ERealActState.ACTIVITY_HODING);
		} else if (endTime != null && day > endTime.getTime()) { // 活动结束
			return getState(ERealActState.ACTIVITY_FINISHED);
		}
		return NOT_MATCH_STATE;
	}
	
}
