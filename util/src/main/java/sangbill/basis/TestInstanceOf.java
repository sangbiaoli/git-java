package com.sangbill.basis;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TestInstanceOf {
	public static void main(String[] args) {
		Map<String,Object> map = new HashMap<String,Object>();
		BigDecimal bd = new BigDecimal(345);
		BigDecimal bd2 = null;	
		map.put("BD", bd);
		map.put("BD2", bd2);
		map.put("STRING", "I am String");
		map.put("INTEGER", 12);
		Map<String,Object> map2 =  readMap(map);
		System.out.println(map);
		System.out.println(map2);
		System.out.println((Integer)map2.get("bd"));
		System.out.println((Integer)map2.get("bd2"));

	}
	/**
	 * 把大写转化为小写
	 * @param map
	 * @return
	 */
	private static Map<String, Object> readMap(Map<String, Object> map) {
		Iterator it = map.entrySet().iterator();
		Map<String,Object> lowerMap = new HashMap<String,Object>();
		while(it.hasNext()){
			Map.Entry entry = (Map.Entry)it.next();
			Object key = entry.getKey();
			Object value = entry.getValue();
			if(value instanceof BigDecimal){
				lowerMap.put(key.toString().toLowerCase(), parseInt(value));
			}else{		
				lowerMap.put(key.toString().toLowerCase(), value);
			}
		}
		return lowerMap;	
	}
	
	/**
	 * 大数据类型转换为int
	 * @param object
	 * @return
	 */
	public static Integer parseInt(Object object) {
		if(object==null)return null;
		BigDecimal b = (BigDecimal)object;
		return b.intValue();
	}
	
}
