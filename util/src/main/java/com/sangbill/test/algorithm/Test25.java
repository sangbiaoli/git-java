package com.sangbill.test.algorithm;

import java.util.Arrays;

public class Test25 {
	public static int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        for(;i<nums.length;i++){
        	if(nums[i] > 0){
        		break;
        	}
        }
        //全负数
        if(i == nums.length){
        	return 1;
        }
        
        //正数开始循环
        if(nums[i] > 1){
        	return 1;
        }else{
        	for(;i< nums.length - 1 ;i++){
        		//出现不连续
        		if(i <= nums.length - 2 && nums[i+1] - nums[i] > 1 ){
        			return nums[i]+1;
        		}
        	}
        	//所有都连续
        	return nums[i]+1;
        }
    }

	public static void main(String[] args) {
		int[] nums = new int[] {1,1000};
		System.out.println(firstMissingPositive(nums));
	}
}