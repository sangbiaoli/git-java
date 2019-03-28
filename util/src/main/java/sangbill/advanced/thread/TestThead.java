package com.sangbill.advanced.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThead {
	Map<String, Integer> map;
	
	public TestThead(Map<String, Integer> map) {
		this.map = map;
	}

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);
		TestThead test = new TestThead(map);
		test.execute();
	}

	private void execute() {
		int size = 10;
		ExecutorService service1 = Executors.newFixedThreadPool(size);
		ExecutorService service2 = Executors.newFixedThreadPool(size);
		ExecutorService service3 = Executors.newFixedThreadPool(size);
		for (int i = 0; i < size; i++) {
			service1.execute(new AddCount("a"));
			service2.execute(new AddCount("b"));
			service3.execute(new AddCount("c"));
		}
		System.out.println(map);
	}
	
	public  class AddCount implements Runnable{
		private String key;
		
		public AddCount(String key) {
			this.key = key;
		}

		public void run() {
			Integer val  = map.get(key);
			val++;
			map.put(key, val);
		}
	}
}
