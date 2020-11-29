package com.sangbill.leecode.other;

public class T0011_containerWithMostWater {
	public static int maxArea(int[] height) {
        int len = height.length;

        int max = 0;
        for(int i = 0;i < len;i++){
            int tempMax = 0;
            for(int j = i+1;j< len;j++){
                int tempHeight = Math.min(height[i],height[j]);
                if(tempMax < (j-i)*tempHeight){
                    tempMax =  (j-i)*tempHeight;
                }
            } 
            if(max < tempMax){
                max = tempMax;
            }
        }
        return max;
    }

	public static void main(String[] args) {
		int[] nums = new int[] {1,8,6,2,5,4,8,3,7}; //49
		System.out.println(maxArea(nums));
	}
}
