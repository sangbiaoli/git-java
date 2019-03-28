package com.sangbill.advanced.collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class TestHashSet {
	public static void main(String[] args) {
		testHashSet();
		testHashMap();
	}

	private static void testHashMap() {
		int[] arr = { 1, 2, 3, 4, 5, 6, 10, 7, 4, 3 };
		for (int elem : arr) {
			System.out.print(elem + "  ");
		}
		System.out.println();
		HashMap<String, String> arrayMap = new HashMap<String, String>();
		for (int i = 0, length = arr.length; i < length; i++) {
			String key = arr[i] + "";
			if (!arrayMap.containsKey(key)) {
				arrayMap.put(key, "1");
			} else {
				int count = Integer.parseInt(arrayMap.get(key));
				arrayMap.put(key, ++count + "");
			}
		}

		System.out.println(arrayMap);

		Iterator<Entry<String, String>> it = arrayMap.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, String> entry = (Entry<String, String>) it.next();
			System.out.println(String.format("key = %s count = %s",
					entry.getKey(), entry.getValue()));
		}

	}

	private static void testHashSet() {
		Set<String> set = new HashSet<String>();

		set.add("London");
		set.add("Paris");
		set.add("New York");
		set.add("San Francisco");
		set.add("Beijing");
		set.add("New York");

		System.out.println(set);

		for (Iterator<String> iterator = set.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());
		}
		System.out.println();
	}
}
