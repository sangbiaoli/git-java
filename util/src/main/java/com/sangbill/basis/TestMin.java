package com.sangbill.basis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TestMin {
	public static void main(String[] args) {
		Map<Integer,Integer> map =  new HashMap<Integer,Integer>();
		map.put(1, 1);
		map.put(2, 2);
		map.put(3, 3);
		int index = 0;
		Integer[] keys = new Integer[map.size()];
		Integer[] values = new Integer[map.size()];
		for (Iterator<Integer> iterator = map.keySet().iterator(); iterator.hasNext();) {
			Integer key = (Integer) iterator.next();
			keys[index] = key;
			values[index] = map.get(key);
			index++;
		}
		
		System.out.println(keys);
		System.out.println(values);
	}
}
