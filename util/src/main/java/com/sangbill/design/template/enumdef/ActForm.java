package com.sangbill.design.template.enumdef;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 活动形式
 * 
 * @author
 * 
 */
public class ActForm {
	public static Map<Integer, String> ENUMMAP = new LinkedHashMap<Integer, String>();

	public enum EActForm {

		ACT_TEAM(1, "团体活动"),
		ACT_BEAN(2, "天天赚积分活动"),
		ACT_CHECKIN(3,"签到活动"),
		ACT_KNOWLEDGE(4,"知识大通关")
		;
		public String value;
		public int key;

		/**
		 * 构造方法
		 * 
		 * @param value
		 * @param key
		 */
		private EActForm(int key, String value) {
			this.key = key;
			this.value = value;
		}
	}

	static {
		for (EActForm ect : EActForm.values()) {
			ENUMMAP.put(ect.key, ect.value);
		}
	}
}