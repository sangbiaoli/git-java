package com.sangbill.sort;

import java.util.Random;

public class SortTest {
	public static void main(String[] args) {
		int[] array = randomInt(10);
		print("before", array);
		// SortUtils.bubbleSort(arr);
		// SortUtils.selectionSort(array);
		// SortUtils.insertionSort(array);
		SortUtils.shellSort(array);
		print("after", array);
	}

	private static int[] randomInt(int length) {
		Random r = new Random();
		int[] array = new int[length];
		for (int i = 0; i < length; i++) {
			array[i] = r.nextInt(50);
		}
		return array;
	}

	private static void print(String msg,int[] array) {
		System.out.print(msg+":\t");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+",");
		}		
		System.out.println();
	}
}
