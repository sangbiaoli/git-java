package com.sangbill.leecode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T0015_threeSum {
	public static List<List<Integer>> threeSum(int[] nums, int target) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		int len = nums.length;
		if (len < 3) {
			return list;
		}

		Arrays.sort(nums);
		// 留有最少两个最右边的数用于双指针扫描
		for (int j = 0; j < len - 2; j++) {
			int curSum = target - nums[j];
			int start = j + 1;
			int end = len - 1;
			// 双指针扫描
			while (start < end) {
				// 找到一个解
				if (nums[start] + nums[end] == curSum) {
					list.add(Arrays.asList(nums[j], nums[start], nums[end]));
					start++;
					end--;
					// 去 start 重复
					while (start < end && nums[start - 1] == nums[start]) {
						start++;
					}
					// 去 end 重复
					while (start < end && nums[end + 1] == nums[end]) {
						end--;
					}
				} else if (nums[start] + nums[end] < curSum) {
					start++;
				} else {
					end--;
				}
			}
			// 去 j 重复
			while (j < len - 2 && nums[j] == nums[j + 1]) {
				j++;
			}
		}
		return list;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { -1, 0, -5, -2, -2, -4, 0, 1, -2 };
		int target = -2;
		System.out.println(threeSum(nums, target));
	}
}
