package com.sangbill.leecode.string;

public class T926_minFlipsMonoIncr {

	public static int minFlipsMonoIncr(String S) {
		int len = S.length();
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
        	array[i] = Integer.parseInt(S.charAt(i)+"");
		}
        int min = Integer.MAX_VALUE;
        //全0
        for (int i = 0; i < len; i++) {
        	int temp = 0;
        	for(int j = i - 1; j >= 0;j --){
        		if(array[j] == 1){     				
        			temp++;
            	}
        	}
        	for(int j = i + 1; j < len;j ++){
        		if(array[j] == 0){
        			temp++;
            	}
        	}
        	if(min > temp){
        		min = temp;
        	}
        }
        return min;   
    }

	public static void main(String[] args) {
		String str = "00110";
		System.out.println(minFlipsMonoIncr(str));
	}
}
