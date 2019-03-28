package com.sangbill.basis;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class TestStack {
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String,String>();
//		map.put("0", "0");
//		map.put("a", "a");
		/*map.put("a/b", "b");
		map.put("a/b/c", "c");
		map.put("a/b/c/d", "d");*/
		Stack<String> s = new Stack<String>();
		String a = "a/b/c";
		int index;
		while(!map.containsKey(a)){	//依次获取父路径，并判断是否已经在ITM中
			s.push(a);
			index = a.lastIndexOf("/");
			if(index >-1){				
				a = a.substring(0,index);
			}else{
				break;
			}
//			System.out.println(a);
		}
		if(s.isEmpty()){
//			System.out.println(a);
		}else{			
			System.out.println("==================");//a作为跟了
			while (!s.isEmpty()) {
				System.out.println(a);
				a = s.pop();
			}
//			System.out.println(a);
		}
	}
}
