package com.sangbill.sort;

public class SortTest {
	public static void main(String[] args) {
//		int[] array = new int[]{9,8,7};
		int[] array = new int[]{7,8,9};

//		SortUtils.bubbleSort(arr);
//		SortUtils.selectionSort(array);
		SortUtils.insertionSort(array);
		print(array);
	}

	private static void print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+",");
		}		
	}
}
