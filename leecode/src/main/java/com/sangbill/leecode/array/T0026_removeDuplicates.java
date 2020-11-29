package com.sangbill.leecode.array;

public class T0026_removeDuplicates {
	
	public int removeDuplicates(int[] nums) {
        if(nums.length == 0)
            return 0;
        int cnt=0;
        for(int i = 0;i < nums.length;i++){
            if(nums[cnt] != nums[i]){
                nums[++cnt] = nums[i];
            }
        }
        return cnt+1;
    }
}
