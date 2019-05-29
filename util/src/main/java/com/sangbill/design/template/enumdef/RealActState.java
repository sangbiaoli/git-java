package com.sangbill.design.template.enumdef;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class RealActState {
	public static Map<ERealActState, String> DESC_MAP = new LinkedHashMap<ERealActState, String>();
	
	public enum ERealActState{
		UNRELEASED,
		ENTER_NOT_START,
		ENTERING,
		ENTER_FINISHED,
		ACTIVITY_NOT_START,
		ACTIVITY_HODING,
		ACTIVITY_FINISHED,
		CANCELED
	}
	
	public enum EActStateDesc{
		UNRELEASED(ERealActState.UNRELEASED,"未发布"),
		ENTER_NOT_START(ERealActState.ENTER_NOT_START,"报名未开始"),
		ENTERING(ERealActState.ENTERING,"报名中"),
		ENTER_FINISHED(ERealActState.ENTER_FINISHED,"报名结束"),
		ACTIVITY_NOT_START(ERealActState.ACTIVITY_NOT_START,"活动未开始"),
		ACTIVITY_HODING(ERealActState.ACTIVITY_HODING,"活动中"),
		ACTIVITY_FINISHED(ERealActState.ACTIVITY_FINISHED,"活动结束"),
		CANCELED(ERealActState.CANCELED,"已撤回");

		private ERealActState eActState;
		private String value;
		private EActStateDesc(ERealActState eActState, String value) {
			this.eActState = eActState;
			this.value = value;
		}
		public ERealActState getEActState() {
			return eActState;
		}
		public void setEActState(ERealActState eActState) {
			this.eActState = eActState;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
	}
	

	static {
		for (EActStateDesc ect : EActStateDesc.values()) {
			DESC_MAP.put(ect.eActState, ect.value);
		}
	}
	
	public static Map<Integer,String> getStateMap(Map<ERealActState, Integer> enumMap){
		Map<Integer, String> map = new LinkedHashMap<Integer, String>();
		for (Iterator<ERealActState> it = enumMap.keySet().iterator(); it.hasNext();) {
			ERealActState key = it.next();
			if(DESC_MAP.containsKey(key)){
				map.put(enumMap.get(key), DESC_MAP.get(key));
			}
		}
		return map;
	}
}
