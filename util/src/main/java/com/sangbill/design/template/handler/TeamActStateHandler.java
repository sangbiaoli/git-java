package com.sangbill.design.template.handler;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Component;

import com.sangbill.design.template.AbstactActStateHandler;
import com.sangbill.design.template.enumdef.RealActState.ERealActState;
import com.sangbill.design.template.enumdef.act.TeamActState;
import com.sangbill.util.DateUtil;

@Component
public class TeamActStateHandler extends AbstactActStateHandler{

	
	public TeamActStateHandler() {
		super(TeamActState.ENUMMAP);
	}

	@Override
	public int getReleaseActState(Date startTime, Date endTime, Date enterStartTime, Date enterEndTime,
			String actDetailJson) {
		long now = DateUtil.now().getTime();
		long day = DateUtils.truncate(DateUtil.now(), Calendar.DATE).getTime();
		
		if (enterStartTime != null && enterStartTime.getTime() > now) { // 报名未开始
			return getState(ERealActState.ENTER_NOT_START);
		} else if (enterStartTime != null && enterEndTime != null && enterStartTime.getTime() <= now && now <= enterEndTime.getTime()) { // 报名中
			return getState(ERealActState.ENTERING);
		} else if (enterEndTime.getTime() < now && day < startTime.getTime()) { // 报名结束
			return getState(ERealActState.ENTER_FINISHED);
		} else if (startTime.getTime() <= day && day <= endTime.getTime()) { // 活动中
			return getState(ERealActState.ACTIVITY_HODING);
		} else if (day > endTime.getTime()) { // 活动结束
			return getState(ERealActState.ACTIVITY_FINISHED);
		}
		return NOT_MATCH_STATE;
	}
	
}
