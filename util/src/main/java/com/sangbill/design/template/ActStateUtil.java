package com.sangbill.design.template;

import java.util.Date;

import com.sangbill.design.template.enumdef.ActForm.EActForm;
import com.sangbill.design.template.handler.BeanActStateHandler;
import com.sangbill.design.template.handler.CheckinActStateHandler;
import com.sangbill.design.template.handler.KnowledgeActStateHandler;
import com.sangbill.design.template.handler.TeamActStateHandler;
import com.sangbill.util.SpringUtils;

public class ActStateUtil {
	
	public static int getActState(int form, int state, Date startTime, Date endTime, Date enterStartTime, Date enterEndTime,String actDetailJson) {
		AbstactActStateHandler handler = null;
		if(form == EActForm.ACT_TEAM.key){
			handler = SpringUtils.getBean(TeamActStateHandler.class);
		}else if(form == EActForm.ACT_BEAN.key){
			handler = SpringUtils.getBean(BeanActStateHandler.class);
		}else if(form == EActForm.ACT_CHECKIN.key){
			handler = SpringUtils.getBean(CheckinActStateHandler.class);
		}else if(form == EActForm.ACT_KNOWLEDGE.key){
			handler = SpringUtils.getBean(KnowledgeActStateHandler.class);
		}
		return handler.getActState(state, startTime, endTime, enterStartTime, enterEndTime, actDetailJson);
	}
}