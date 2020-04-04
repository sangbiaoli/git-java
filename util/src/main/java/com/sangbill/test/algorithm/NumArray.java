package com.sangbill.test.algorithm;
class NumArray {
    private int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
    }
    
    public int sumRange(int i, int j) {
        if(i > j || nums == null || nums.length == 0 || i >= nums.length || j >= nums.length ){
            return 0;
        }
        int sum = 0;
        for(int k = i;k <= j;k++){
            sum += nums[k];
        }
        return sum;
    }
}