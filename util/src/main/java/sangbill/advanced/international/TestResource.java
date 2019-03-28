package com.sangbill.advanced.international;

import java.util.ResourceBundle;
import java.util.Set;



public class TestResource {
	public static void main(String[] args) {
		ResourceBundle res = ResourceBundle.getBundle("MyResource");
		
		Set<String> set = res.keySet();
		for (String key : set) {
			System.out.println(key+" = "+res.getString(key));
		}
	}
}
