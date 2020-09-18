package com.sangbill.leecode.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class T0001_godName {
	
	private List<List<Integer>> godName(int N) {
		List<List<Integer>> list = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		backTrap(list,stack,1,N,N);
		return list;
	}

	private void backTrap(List<List<Integer>> list, Stack<Integer> stack, int i, int sum , int N) {
		if(sum < 0){
			return;
		}
		if(sum == 0){
			list.add(new ArrayList<>(stack));
			return;
		}
		for(int j = i;j <= N;j ++){
			stack.push(j);
			backTrap(list, stack, j, sum - j, N);
			stack.pop();
		}
	}

	public static void main(String[] args) {
		T0001_godName t = new T0001_godName();
		List<List<Integer>> list = t.godName(7);
		System.out.println(list.size());
	}
}
	
