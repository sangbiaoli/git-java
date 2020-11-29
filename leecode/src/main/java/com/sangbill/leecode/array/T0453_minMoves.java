package com.sangbill.leecode.array;
/**
 * 最小移动次数使数组元素相等
 * @author Bill
 *
 */
public class T0453_minMoves {
    public int minMoves(int[] nums) {
        int moves = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            moves += nums[i] - min;
        }
        return moves;
    }
}