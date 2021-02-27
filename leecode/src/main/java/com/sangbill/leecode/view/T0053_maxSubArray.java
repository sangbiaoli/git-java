package com.sangbill.leecode.view;

class T0053_maxSubArray {
    public int maxSubArray(int[] nums) {
        int dp = nums[0], res = dp;
        for(int i = 1; i < nums.length; i++) {
            dp = dp <= 0 ? nums[i] : dp + nums[i];
            res = Math.max(res, dp);
        }
        return res;
    }

    public static void main(String[] args) {
        T0053_maxSubArray su = new T0053_maxSubArray();
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int res = su.maxSubArray(nums);
        System.out.println(res);
    }
}