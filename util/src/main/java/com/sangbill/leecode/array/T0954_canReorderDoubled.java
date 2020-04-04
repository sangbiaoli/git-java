package com.sangbill.leecode.array;

import java.util.Arrays;

public class T0954_canReorderDoubled {
	
	public static boolean canReorderDoubled(int[] A) {
		int[] flag = new int[A.length];
		for (int i = 0; i < flag.length; i++) {
			flag[i] = 0;
		}
		Arrays.sort(A);
		int i = 0;
		
		while(i < A.length){
			//还没用到
			if(flag[i] == 0){
				boolean b = false;
				//负数
				if(A[i] < 0){
					for (int j = i + 1; j < A.length; j++) {
						if(flag[j] == 0 && A[i] == A[j] * 2){
							flag[i] = 1;
							flag[j] = 1;
							b = true;
							break;
						}
					}
				}else{
					for (int j = i + 1; j < A.length; j++) {
						if(flag[j] == 0 && A[i] * 2 == A[j]){
							flag[i] = 1;
							flag[j] = 1;
							b = true;
							break;
						}
					}
				}
				if(b == false){
					break;
				}
			}
			i++;			
		}
		return (i == A.length);	
	}

	public static void main(String[] args) {
		int[] nums = new int[]{2,1,2,1,1,1,2,2};
		System.out.println(canReorderDoubled(nums));
	}
}
