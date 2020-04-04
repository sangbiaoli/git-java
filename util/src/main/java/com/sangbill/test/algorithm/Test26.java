package com.sangbill.test.algorithm;

public class Test26 {
	public static int trap(int[] height) {
		int len = height.length;
		if(height.length < 3)
			return 0;
		
		int sum = 0;
		//找出左边和右边第一个凹下去的位置
		int left = 0,right = len - 1;
		while (left < len) {
			if (left + 1 < len - 1 && height[left] == height[left + 1]) {
				left++;
			} else {
				break;
			}
		}
		while (right >= 0) {
			if (right - 1 >= 0 && height[right - 1] == height[right]) {
				right--;
			} else {
				break;
			}
		}
		
		if(left >= right){
			return 0;			
		}
		
		//寻找凹槽
		while(left < right){
			int base = height[left];
			int index = left + 1;
			int maxIndex = left + 1;
			boolean higher = false;
			while(index <= right){
				if(height[index] >= base){
					higher = true;
					break;
				}else{
					if(height[maxIndex] < height[index]){
						maxIndex = index;
					}
				}
				index++;
			}
			
			
			if(higher){ //找到了比left大或等于，添加水滴并查找新的left
				sum += addDrop(height, left, index);
				while(index <= right){
					if(index + 1 <= right && height[index] <= height[index + 1]){
						index++;
					}else{
						break;
					}
				}
				left = index;
			}else{ //没有找到，则在剩下的节点找出最大
				sum += addDrop(height, left, maxIndex);
				left = maxIndex;
			}
		}		
		return sum;
	}

	private static int addDrop(int[] height, int left, int right) {
		int sum = 0;
		int min = Math.min(height[left], height[right]);
		for (int i = left+1; i < right; i++) {
			if(height[i] < min){
				sum += min - height[i];
			}
		}
		return sum;
	}

	public static void main(String[] args) {
//		int[] nums = new int[] {0,1,0,2,1,0,1,3,2,1,2,1}; //6
		int[] nums = new int[] {2,0,2}; //2
//		int[] nums = new  int[] {5,2,1,2,1,5};
//		int[] nums = new int[] {5,5,1,7,1,1,5,2,7,6}; //23
//		int[] nums = new int[] {9,6,8,8,5,6,3}; //3
//		int[] nums = new int[] {9,2,9,3,2,2,1,4,8}; //35
		System.out.println(trap(nums));
	}
}