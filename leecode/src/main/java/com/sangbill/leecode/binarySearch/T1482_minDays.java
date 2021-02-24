package com.sangbill.leecode.binarySearch;

public class T1482_minDays {
	public int minDays(int[] bloomDay, int m, int k) {
		if(bloomDay.length < m * k ) {
			return -1;
		}
		int left = 0, right = Integer.MIN_VALUE,mid = 0;
		for(int day:bloomDay){
			right = Math.max(right,day);
		}
		while (left < right){
			mid = left + right >>> 1;
			if(canMake(bloomDay,k,m,mid)){
				right = mid ;
			}else{
				left = mid + 1;
			}
		}
		return left;
	}

	public boolean canMake(int[] bloomDays,int k,int m,int maxBloomDay){
		int n = bloomDays.length, l = 0;
		for(int i = 0;;) {
			int bloomDay = bloomDays[i++];
			if(bloomDay <= maxBloomDay) {
				if(++l == k) {
					if (--m == 0) {
						return true;
					}
					l = 0;
				}
			} else {
				if(i + m * k > n) {
					return false;
				}
				l = 0;
			}
		}
	}

	public static void main(String[] args) {
		T1482_minDays su = new T1482_minDays();
		int[] bloomDay = {1,10,3,10,2};
		int m = 3;
		int k = 1;
		System.out.println(su.minDays(bloomDay,m,k));
	}
}
