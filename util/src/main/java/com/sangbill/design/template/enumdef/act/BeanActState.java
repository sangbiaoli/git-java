package com.sangbill.design.template.enumdef.act;

import java.util.LinkedHashMap;
import java.util.Map;

import com.sangbill.design.template.enumdef.RealActState.ERealActState;

public class BeanActState {
	public static Map<ERealActState, Integer> ENUMMAP = new LinkedHashMap<ERealActState, Integer>();

	public enum EBeanActState {
		UNRELEASED(ERealActState.UNRELEASED,-1), 
		ACTIVITY_NOT_START(ERealActState.ACTIVITY_NOT_START,3), 
		ACTIVITY_HODING( ERealActState.ACTIVITY_HODING,4), 
		ACTIVITY_FINISHED(ERealActState.ACTIVITY_FINISHED,5), 
		CANCELED(ERealActState.CANCELED,-2);
		
		public ERealActState key;
		public int value;

		private EBeanActState(ERealActState key, int value) {
			this.key = key;
			this.value = value;
		}
	}
	
	static {
		for (EBeanActState ect : EBeanActState.values()) {
			ENUMMAP.put(ect.key, ect.value);
		}
	}
}
