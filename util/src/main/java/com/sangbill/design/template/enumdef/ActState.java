package com.sangbill.design.template.enumdef;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 * 表ActActivity的状态字段
 * @author liqiangbiao
 * @date 2019年5月16日
 */
public class ActState {
	public static Map<Integer, String> ENUMMAP = new LinkedHashMap<Integer, String>();

	public enum EActState {

		TO_BE_RELEASED(0, "待发布"),
		RELEASE(1, "发布"),
		FORBID(2, "禁用"),
		RECALL(3, "撤回"),
		DELETE(9, "删除");
		public String value;
		public int key;

		/**
		 * 构造方法
		 * 
		 * @param value
		 * @param key
		 */
		private EActState(int key, String value) {
			this.key = key;
			this.value = value;
		}
	}

	static {
		for (EActState ect : EActState.values()) {
			ENUMMAP.put(ect.key, ect.value);
		}
	}
}