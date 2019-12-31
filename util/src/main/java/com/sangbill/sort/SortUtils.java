package com.sangbill.sort;

public class SortUtils {
	
	private static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	/**
	 * 冒泡排序
	 * @author liqiangbiao
	 * 2019年12月31日
	 *  @param array
	 * void
	 */
	public static void bubbleSort(int[] array) {
		if(array.length <= 1)
			return;
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if((j + 1) < array.length && array[j] > array[j + 1]){
					swap(array,j,j+1);
				}
			}
		}
	}
	/**
	 * 选择排序
	 * @author liqiangbiao
	 * 2019年12月31日
	 *  @param array
	 * void
	 */
	public static void selectionSort(int[] array) {
		if(array.length <= 1)
			return;
		
		for (int i = 0; i < array.length; i++) {
			int minIndex = i;
			for (int j = i; j < array.length; j++) {
				if(array[minIndex] > array[j]){
					minIndex = j;
				}
			}
			swap(array,minIndex,i);
		}		
	}
	/**
	 * 插入排序
	 * @author liqiangbiao
	 * 2019年12月31日
	 *  @param array
	 * void
	 */
	public static void insertionSort(int[] array) {
		if (array.length <= 1)
			return;

		for (int i = 1; i < array.length; i++) {
			int temp = array[i];
			int j = i - 1;
			while (j >= 0 && array[j] > temp) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = temp;
		}
	}

}
