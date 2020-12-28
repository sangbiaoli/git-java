package com.sangbill.leecode.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class T0496_nextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Arrays.fill(ans,-1);
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums2.length;i++){
            map.put(nums2[i],i);
        }
        for(int i = 0;i < nums1.length;i++){
            for(int j = map.get(nums1[i]);j < nums2.length;j++){
                if(nums1[i] < nums2[j]){
                    ans[i] = nums2[j];
                    break;
                }
            }
        }
        return ans;
    }
}