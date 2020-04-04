package com.sangbill.test.algorithm;

public class Test5 {

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len = nums1.length + nums2.length;
		int[] rs = new int[len];
		
		int n = 0;
		int m = 0;
		int i = 0;
		while(n < nums1.length && m < nums2.length){
			if (nums1[n] < nums2[m]) {
				rs[i] = nums1[n];
				n++;
			} else {
				rs[i] = nums2[m];
				m++;
			}
			i++;
		}
		while(n < nums1.length){
			rs[i] = nums1[n];
			n++;
			i++;
		}
		while(m < nums2.length){
			rs[i] = nums2[m];
			m++;
			i++;
		}
		
		double d;
		if(len % 2 == 0){
			double d1 = rs[len/2 - 1];
			double d2 = rs[len/2];

			d = (d1 + d2)/2;
		}else{
			d = rs[(len -1)/2];
		}
		return d;
	}

	public static void main(String[] args) {
		int[] nums1 = {1,3};
		int[] nums2 = {2};
		System.out.println(findMedianSortedArrays(nums1,nums2));
	}
}
