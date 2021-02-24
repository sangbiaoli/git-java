package com.sangbill.leecode.array;

import java.util.ArrayList;
import java.util.List;

class T0442_findDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int index;
        for (int i = 0; i < nums.length; ++i) {
            index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0){
                nums[index] = - nums[index];
            }else{
                res.add(index+1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        T0442_findDuplicates su = new T0442_findDuplicates();
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> list = su.findDuplicates(nums);
        System.out.println(list);
    }
}