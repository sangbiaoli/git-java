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
	 * 堆排序：以大顶堆为例
	 * @param array
	 */
	public static void heapSort(int[] array) {
		if (array.length <= 1)
			return;
		
		//从整个堆的最后一个非叶子节点开始，循环完所有则变成了大顶堆
		for (int i = array.length / 2 - 1; i >= 0; i--) {
			adjustHeap(array,i,array.length);
		}
		//调整对结构+交换堆顶与末尾元素
		for (int j = array.length - 1; j > 0; j--) {
			swap(array, 0, j); //将堆顶元素与末尾元素进行交换
			adjustHeap(array, 0, j); //重新对堆进行调整
		}
	}
	
	/**
	 * 调整完所有非叶子节点，该节点要与子节点比较并置换 <br>
	 * 调整完一遍，保证最大的元素浮在根节点，为下一步交换做准备
	 * @param array
	 * @param i
	 * @param length
	 */
	private static void adjustHeap(int[] array, int i, int length) {
		int temp = array[i];// 先取出当前元素i
		for (int k = i * 2 + 1; k < length; k = k * 2 + 1) { // 从i节点的左子节点元素开始
			//尝试寻找右节点，存在则比较，如果右节点更大，则k指向右节点
			if(k + 1 < length && array[k] < array[k+1]){
				k++;
			}
			//如果子节点(不管是左还是右，都是大的那一个)大于父节点，将子节点赋值父节点
			if(array[k] > temp){ 
				array[i] = array[k];
				i = k;
			}else{
				break;
			}
		}
		array[i] = temp;	
	}
	
	/**
	 * 标记最大与最小，并记录这个区间的所有数的记数，循环这些计数重置数组
	 * 计数排序局限性较大，对于重复值较多的数组比较有用
	 * @param array
	 */
	public static void countSort(int[] array) {
		if (array.length <= 1)
			return;

		// 寻找最小与最大
		int min = array[0], max = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
			if (array[i] < min) {
				min = array[i];
			}
		}
		// 开始计数
		int[] bucket = new int[max - min + 1];
		Arrays.fill(bucket, 0);
		for (int i = 0; i < array.length; i++) {
			bucket[array[i] - min]++;
		}

		int index = 0;
		// 组装结果
		for (int i = min; i <= max; i++) {
			int cnt = bucket[i - min];
			while (cnt > 0) {
				array[index] = i;
				index++;
				cnt--;
			}
		}
	}

}
