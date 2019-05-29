package com.sangbill.design.template.enumdef.act;

import java.util.LinkedHashMap;
import java.util.Map;

import com.sangbill.design.template.enumdef.RealActState.ERealActState;

public class TeamActState {
	public static Map<ERealActState, Integer> ENUMMAP = new LinkedHashMap<ERealActState, Integer>();

	public enum ETeamActState {
		UNRELEASED(ERealActState.UNRELEASED,-1), 
		ENTER_NOT_START(ERealActState.ENTER_NOT_START,1), 
		ENTERING(ERealActState.ENTERING,2), 
		ENTER_FINISHED( ERealActState.ENTER_FINISHED,3), 
		ACTIVITY_HODING(ERealActState.ACTIVITY_HODING,4), 
		ACTIVITY_FINISHED(ERealActState.ACTIVITY_FINISHED,5),
		CANCELED(ERealActState.CANCELED,-2);

		public ERealActState key;
		public int value;

		private ETeamActState(ERealActState key, int value) {
			this.key = key;
			this.value = value;
		}
	}
	
	static {
		for (ETeamActState ect : ETeamActState.values()) {
			ENUMMAP.put(ect.key, ect.value);
		}
	}
}
