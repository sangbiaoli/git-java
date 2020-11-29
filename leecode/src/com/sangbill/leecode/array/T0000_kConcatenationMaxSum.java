package com.sangbill.leecode.array;

public class T0000_kConcatenationMaxSum {
	
	public static int kConcatenationMaxSum(int[] arr, int k) {
		if (arr.length == 0 || k == 0)
			return 0;

		long[] rs = new long[2];
		setMaxValue(arr, rs);
		if(k >= 2){
			setMaxValue(arr, rs);
		}
		
		long y = rs[1];
		if(k < 3)
			return (int) (y%1000000007);
		
		long s = sum(arr);
        return (int) ((s > 0?(s * (k -2)+y):y)%1000000007);
    }
    
	private static void setMaxValue(int[] arr,long[] rs) {
		for (int i = 0; i < arr.length; i++) {
			rs[0] = Math.max(arr[i], rs[0] + arr[i]);
			if (rs[0] > rs[1]) {
				rs[1] = rs[0];
			}
		}
	}
	
    private static long sum(int[] arr) {
    	long sum = 0;
		for(int a :arr){
			sum += a;
		}
		return sum;
	}

	public static void main(String[] args) {
		int[] arr = new int[]{1,2};
//		int[] arr = new int[]{1,-2,1};
//		int[] arr = new int[]{-1,-2};
    	int k = 5;
    	int sum = kConcatenationMaxSum(arr,k);
    	System.out.println(sum);
	}
}
