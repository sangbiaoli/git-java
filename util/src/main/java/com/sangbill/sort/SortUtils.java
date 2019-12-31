package com.sangbill.sort;

import java.util.Arrays;

public class SortUtils {
	
	private static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	/**
	 * 冒泡排序：相邻做交换
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
	 * 选择排序：挑选最大或最小，再交换
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
	 * 插入排序：从某个位置往回比较并插入，一直保持前面是有序的
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
	/**
	 * 希尔排序：切分分组，并用插入排序法（距离为gap）对分组内的元素进行配许
	 * @author liqiangbiao
	 * 2019年12月31日
	 *  @param array
	 * void
	 */
	public static void shellSort(int[] array) {
		if (array.length <= 1)
			return;
		
		int len = array.length;
		int gap = len / 2;
		while(gap > 0){
			for (int i = gap; i < len; i++) {
				insertionSort(array,gap,i);
			}
			gap /= 2;
		}
		
	}
	/**
	 * 从数组i的位置开始，以gap的距离进行插入排序
	 * @author liqiangbiao
	 * 2019年12月31日
	 *  @param array
	 *  @param gap
	 *  @param i
	 * void
	 */
	private static void insertionSort(int[] array, int gap, int i) {
		int temp = array[i];
		int j = i - gap;
		while (j >= 0 && array[j] > temp) {
			array[j + gap] = array[j];
			j -= gap;
		}
		array[j + gap] = temp;
	}
	
	/**
	 * 归并排序
	 * @param array
	 */
	public static int[] mergeSort(int[] array) {
		if (array.length <= 1)
			return array;
		
		int mid = array.length / 2;
		int[] left = Arrays.copyOfRange(array, 0, mid);
		int[] right = Arrays.copyOfRange(array, mid,array.length);
		return merge(mergeSort(left),mergeSort(right));
	}
	
	/**
	 * 归并排序，左或右有一方到了尽头，则另一方可以连续赋值（不做比较），否则比较谁低，谁赋值
	 * @param left
	 * @param right
	 * @return
	 */
	private static int[] merge(int[] left, int[] right) {
		int[] result = new int[left.length + right.length];
		for (int index = 0, i = 0, j = 0; index < result.length; index++) {
			if (i >= left.length) {
				result[index] = right[j++];
			} else if (j >= right.length) {
				result[index] = left[i++];
			} else if (left[i] > right[j]) {
				result[index] = right[j++];
			} else {
				result[index] = left[i++];
			}
		}
		return result;
	}
	
	/**
	 * 快速排序
	 * @param array
	 */
	public static void quickSort(int[] array) {
		if (array.length <= 1)
			return;
		
		subQuickSort(array, 0, array.length - 1);
	}
	
	private static void subQuickSort(int[] array, int start, int end) {
		if (start >= end)
			return;

		int middleIndex = subQuickSortCore(array, start, end);
		subQuickSort(array, start, middleIndex - 1);
		subQuickSort(array, middleIndex + 1, end);
	}
	/**
	 * 快速排序：
	 * 1.start作为从左向右逼近的游标，遇到比基准小则+1，否则停止并置换
	 * 2.end作为从右到左逼近的游标，遇到比基准大则-1，否则停止并置换
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 */
	private static int subQuickSortCore(int[] array, int start, int end) {
		int middleValue = array[start];
		while (start < end) {		
			while (array[end] >= middleValue && start < end) {
				end--;
			}
			array[start] = array[end];
			while (array[start] <= middleValue && start < end) {
				start++;
			}
			array[end] = array[start];
		}
		array[start] = middleValue;
		return start;
	}
	/**
	 * 堆排序
	 * @param array
	 */
	public static void heapSort(int[] array) {
		// TODO Auto-generated method stub
		
	}

}
