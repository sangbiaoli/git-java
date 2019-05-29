package com.sangbill.design.template.enumdef.act;

import java.util.LinkedHashMap;
import java.util.Map;

import com.sangbill.design.template.enumdef.RealActState.ERealActState;

public class KnowledgeActState {
	public static Map<ERealActState, Integer> ENUMMAP = new LinkedHashMap<ERealActState, Integer>();

	public enum ECheckinActState {
		UNRELEASED(ERealActState.UNRELEASED,0), 
		ACTIVITY_NOT_START(ERealActState.ACTIVITY_NOT_START,4), 
		ACTIVITY_HODING( ERealActState.ACTIVITY_HODING,5), 
		ACTIVITY_FINISHED(ERealActState.ACTIVITY_FINISHED,6), 
		CANCELED(ERealActState.CANCELED,7);
		
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
