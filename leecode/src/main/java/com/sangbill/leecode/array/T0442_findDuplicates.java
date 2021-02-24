package com.sangbill.leecode.array;

import java.util.ArrayList;
import java.util.List;

class T0442_findDuplicates {
    /**
     * 不加额外空间
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int index;
        for (int i = 0; i < nums.length; ++i) {
            index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            } else {
                res.add(index + 1);
            }
        }
        return res;
    }

    /**
     * 加额外空间，运行更快
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates2(int[] nums) {
        List<Integer> res = new ArrayList<>();//存放结果
        int[] arr = new int[nums.length + 1];//标记每个元素出现的次数
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
        }
        for (int i = 1; i < arr.length; i++) {//存储所有出现两次的元素
            if (arr[i] == 2) res.add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        T0442_findDuplicates su = new T0442_findDuplicates();
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> list = su.findDuplicates(nums);
        System.out.println(list);
    }
}