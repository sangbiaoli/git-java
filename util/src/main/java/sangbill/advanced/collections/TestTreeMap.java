package com.sangbill.advanced.collections;

import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry; 

public class TestTreeMap {
	public static void main(String[] args) {
//		test1();
		test2();
		
	}

	private static void test2() {
		String str1 = new String("xx");
		String str2 = new String("xx");
		System.out.println(str1 == str2);

		Map<String, String> map = new IdentityHashMap<String, String>();
		map.put(str1, "hello");
		map.put(str2, "world");
		for (Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "   " + entry.getValue());
		} 
	}

	private static void test1() {
		TreeMap<String, String> map = new TreeMap<String, String>();
		map.put("2", "1");
		map.put("3", "1");
		
		Iterator<String> iter = map.keySet().iterator();
        while (iter.hasNext()) {
            Object key = iter.next();
            Object value = map.get(key);
            System.out.print("K: " + key);
            System.out.println("\tV: " + value);
        }
		
	}
}
