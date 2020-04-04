package com.sangbill.test.algorithm;

public class Test11 {

	public static int largestRectangleArea(int[] heights) {
		int max = 0;
		for(int i = 0;i < heights.length ;i++){
			int base = heights[i];
			int cnt = 1;
			for(int j = i + 1;j < heights.length;j++){
				if(base <= heights[j]){
					cnt++;
				}else{
					break;
				}
			}
			for(int j = i - 1;j >= 0;j -- ){
				if(base <= heights[j]){
					cnt++;
				}else{
					break;
				}
			}
			if(max < base * cnt){
				max = base * cnt;
			}
		}
        return max;
    }

	public static void main(String[] args) {
		int[] heights = new int[]{2,1,2};
		System.out.println(largestRectangleArea(heights));
	}
}
