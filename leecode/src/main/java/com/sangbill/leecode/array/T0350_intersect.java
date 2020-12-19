package com.sangbill.leecode.array;

import java.util.Arrays;

class T0350_intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] rs = new int[Math.max(nums1.length,nums2.length)];
        int i = 0;
        int j = 0;
        int index = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j]){
                rs[index++]=nums1[i];
                i++;
                j++;
            }else if(nums1[i] > nums2[j]){
                j++;
            }else{
                i++;
            }
        }
        return Arrays.copyOfRange(rs,0,index);
    }
}