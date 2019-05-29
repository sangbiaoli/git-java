package com.sangbill.design.template.enumdef.act;

import java.util.LinkedHashMap;
import java.util.Map;

import com.sangbill.design.template.enumdef.RealActState.ERealActState;

public class CheckinActState {
	public static Map<ERealActState, Integer> ENUMMAP = new LinkedHashMap<ERealActState, Integer>();

	public enum ECheckinActState {
		UNRELEASED(ERealActState.UNRELEASED,0), 
		ENTERING(ERealActState.ENTERING,1), 
		ACTIVITY_NOT_START(ERealActState.ACTIVITY_NOT_START,2), 
		ACTIVITY_HODING( ERealActState.ACTIVITY_HODING,3), 
		ACTIVITY_FINISHED(ERealActState.ACTIVITY_FINISHED,4), 
		CANCELED(ERealActState.CANCELED,5);
		
		public ERealActState key;
		public int value;

		private ECheckinActState(ERealActState key, int value) {
			this.key = key;
			this.value = value;
		}
	}
	
	static {
		for (ECheckinActState ect : ECheckinActState.values()) {
			ENUMMAP.put(ect.key, ect.value);
		}
	}
}
