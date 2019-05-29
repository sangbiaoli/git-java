package com.sangbill.design.template;


import java.util.Date;
import java.util.Map;

import com.sangbill.design.template.enumdef.ActState.EActState;
import com.sangbill.design.template.enumdef.RealActState.ERealActState;

import lombok.Data;

@Data
public abstract class AbstactActStateHandler{
	public final static int NOT_MATCH_STATE = -99;
	private Map<ERealActState, Integer> map;
	
	public AbstactActStateHandler(){
	}
	
	public AbstactActStateHandler(Map<ERealActState, Integer> map) {
		this.map = map;
	}

	public int getActState(int state, Date startTime, Date endTime, Date enterStartTime, Date enterEndTime,String actDetailJson) {
		// 未发布
		if (state == EActState.TO_BE_RELEASED.key) {
			return getState(ERealActState.UNRELEASED);
		}
		//已发布
		if (state == EActState.RELEASE.key){
			return getReleaseActState(startTime,endTime,enterStartTime,enterEndTime,actDetailJson);
		}
		//已取消
		if( state == EActState.RECALL.key){
			return getState(ERealActState.CANCELED);
		}
		return -99;
	}
	
	public abstract int getReleaseActState(Date startTime, Date endTime, Date enterStartTime, Date enterEndTime,
			String actDetailJson);

	protected int getState(ERealActState estate){
		return map.get(estate);
	}
	
}
