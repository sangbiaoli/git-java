package com.sangbill.leecode.array;

public class T0027_removeElement {
	
	public int removeElement(int[] nums, int val) {
        if(nums.length == 0)
            return 0;
        
        int cnt = 0;
        for(int i = 0;i < nums.length;i++){
            if(val != nums[i]){
                nums[cnt] = nums[i];
                cnt++;
            }
        }
        return cnt;
    }
}
