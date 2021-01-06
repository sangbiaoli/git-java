package com.sangbill.leecode.string;

class T0553_optimalDivision {
    public String optimalDivision(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return "";
        }

        StringBuilder sb = new StringBuilder();
        if(len == 1){
            sb.append(nums[0]);
        }else if(len == 2){
            sb.append(nums[0]).append('/').append(nums[1]);
        }else{
            sb.append(nums[0]).append('/').append('(').append(nums[1]);
            for(int i = 2;i < nums.length;i++){
                sb.append('/').append(nums[i]);
            }
            sb.append(')');
        }
        return sb.toString();
    }
}