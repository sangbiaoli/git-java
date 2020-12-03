package com.sangbill.leecode.array;

import java.util.*;
import java.util.stream.Collectors;

class T0315_countSmaller {
    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            res[i]  = findMostLef(nums, i);
            Arrays.sort(nums, i, len);
        }
        return Arrays.stream(res).boxed().collect(Collectors.toList());
    }

    private int findMostLef(int[] nums, int i) {
        if (i == nums.length - 1) {
            return 0;
        }
        if (nums[i] == nums[i + 1]) {  //已经是最小
            return 0;
        }

        int target = nums[i];
        int low = i + 1;
        int high = nums.length - 1;
        int mid;
        while (low <= high) {
            mid = (high + low) >> 1;
            if (nums[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low - i - 1;
    }

    public static void main(String[] args) {
        int[] nums = new  int[]{5,2,6,1};
        T0315_countSmaller su = new T0315_countSmaller();
        List<Integer> list = su.countSmaller(nums);
        System.out.println(list.size());
    }
}