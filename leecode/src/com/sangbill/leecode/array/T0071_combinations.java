package com.sangbill.leecode.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class T0071_combinations {


	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if(n < 0 || k < 0 || n < k)
			return list;
		
		findCombine(n,k,1,new Stack<Integer>(),list);
		return list;
        
    }

	/**
	 * 用stack的方式实现：
	 * stack的大小是k，第一轮数据如：
	 * k		k~n循环
	 * k-1		(k-1)~n循环
	 * ...
	 * 2		2~n循环
	 * 1   		1~n循环
	 * 
	 * stack.size=k则满足
	 * @param n
	 * @param k
	 * @param begin
	 * @param stack
	 * @param list
	 */
	private static void findCombine(int n, int k, int begin, Stack<Integer> stack, List<List<Integer>> list) {
		if(stack.size() == k){
			list.add(toList(stack));
			return;
		}
		for (int i = begin; i <= n; i++) {
			stack.add(i);
			findCombine(n, k, i+1, stack, list);
			stack.pop();
		}
	}


	private static List<Integer> toList(Stack<Integer> stack) {
		List<Integer> list = new ArrayList<Integer>(stack.size());
		for (int i = 0; i < stack.size(); i++) {
			list.add(stack.get(i));
		}
		return list;
	}

	public static void main(String[] args) {
		System.out.println(combine(6,3));
	}
}
