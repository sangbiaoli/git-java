package com.sangbill.leecode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class T0001_repeatSum {
	
	private List<List<Integer>> godName(int[] nums,int N) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		Stack<Integer> stack = new Stack<>();
		backTrap(list,stack,nums,0,N);
		return list;
	}

	private void backTrap(List<List<Integer>> list, Stack<Integer> stack, int[] nums,int i, int sum) {
		if(sum < 0){
			return;
		}
		if(sum == 0){
			list.add(new ArrayList<>(stack));
			return;
		}
		for(int j = i;j < nums.length;j++){
			stack.push(nums[j]);
			backTrap(list, stack,nums, j, sum - nums[j]);
			stack.pop();
		}
	}

	public static void main(String[] args) {
		T0001_repeatSum t = new T0001_repeatSum();
		List<List<Integer>> list = t.godName(new int[]{2,3,7},12);
		System.out.println(list.size());
	}
}
	
