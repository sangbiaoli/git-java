 package com.sangbill.basis;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;


public class TestArray {
	public static void main(String[] args) {
		System.out.println(test2(null,1));	
		System.out.println(test2("",1));	
		System.out.println(test2(Arrays.asList(),1));	
		System.out.println(test2(Arrays.asList("2"),2));
//		test();
		//printCopyArray();

		//printSortArray();

		//printSearchArray();
		
		//printArray();
		/*ArrayList<String> list = new 	ArrayList<String>();
		list.add("a");
		list.add("b");
		String[] data = new String[list.size()];
		list.toArray(data);
		for (int i = 0; i < data.length; i++) {			
			System.out.println(data[i]);
		}*/
		/*Long[] a = new Long[10];
		a[0]=1l;
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		
		List<String> list = Arrays.asList(new String[]{"a","b"});
		System.out.println(list);
		System.out.println(list.contains("a"));
		System.out.println(list.contains("c"));*/
	}

	private static Integer test2(Object obj,Integer n) {
		if(obj == null){
			return -4;
		}
		 if (obj instanceof Collection ) {
			 Collection c  =  (Collection) obj;
			 if(c.isEmpty()){
				 return -4;
			 }
			 if(c.size() < n){
				 return -3;
			 }
		 }  
	   return 0;
	}

	private static void test() {
		HashSet set = null; 
		set =	new HashSet() {{
			 add("XZ13s"); 
			 add("AB21/X"); 
			 add("YYLEX"); 
			 add("AR2D"); 
			 }}; 
		set.add("sdfsf");
		System.out.println(set);
	}

	private static void printArray() {
		int[][] lists = { 
				{ -1, 1, 2, 3}, 
				{ 2, 3, 4, -1 }, 
				{ 3, 4, -1, 1 },
				{ 4, -1, 1, 2 }
				};
		print2DArray(lists);
		lists = killZero(lists);
		print2DArray(lists);
	}

	private static int[][] killZero(int[][] lists) {
		for (int i = 0; i < lists.length; i++) {
			int[] line = lists[i];
			int[] temp = new int[line.length];
			int lastIndex =  line.length-1;
			int index = 0;
			for (int j = line.length-1; j >=0; j--) {
				if(line[j]>-1){
					temp[lastIndex] = line[j];
					lastIndex--;
				}else{
					temp[index] = line[j];
					index++;
				}
			}
			lists[i] = temp;
		}
		return lists;
	}

	private static void print2DArray(int[][] lists) {
		for (int i = 0; i < lists.length; i++) {
			int[] line = lists[i];
			for (int j = 0; j < line.length; j++) {
				if(j<line.length-1){
					System.out.print(line[j]+",");
				}else{
					System.out.println(line[j]);
				}
				
			}
		}
		System.out.println("\n\n");
	}

	private static void printSearchArray() {
		int[] lists = { 2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 60, 79 };
		System.out.println("Index is "
				+ java.util.Arrays.binarySearch(lists, 11));
		char[] chars = { 'a', 'c', 'g', 'x', 'y', 'z' };
		System.out.println("Index is "
				+ java.util.Arrays.binarySearch(chars, 't'));
	}

	// Array sort
	private static void printSortArray() {
		double[] numbers = { 5.0, 4.4, 1.9, 2.9, 3.4, 3.5 };
		printSortDoubleArray("before sort:",numbers,"after sort:");
		char[] chars = { 'a', 'A', '4', 'F', 'D', 'P' };
		printSortCharArray("before sort:",chars,"after sort:");
	}

	
	private static void printSortCharArray(String before, char[] chars,
			String after) {
		System.out.println(before);
		printCharArray(chars);
		java.util.Arrays.sort(chars);
		System.out.println(after);
		printCharArray(chars);
	}

	private static void printCharArray(char[] chars) {
		for (char c : chars) {
			System.out.print(c+" ");
		}
	}

	private static void printSortDoubleArray(String before, double[] numbers,
			String after) {
		System.out.println(before);
		printDoubleArray(numbers);
		java.util.Arrays.sort(numbers);
		System.out.println(after);
		printDoubleArray(numbers);
	}

	private static void printDoubleArray(double[] numbers) {
		for (double d : numbers) {
			System.out.print(d+" ");
		}
		System.out.println();
	}

	/**
	 * Copy An Array from another has three ways as the following: 1.for
	 * statement 2.arraycopy method 3.clone method
	 */
	private static void printCopyArray() {
		int[] Arr1 = { 1, 2, 3, 4, 5 };
		int[] Arr2 = new int[5];
		int[] Arr3 = new int[5];
		int[] Arr4 = new int[5];

		for (int i = 0; i < Arr1.length; i++) {
			Arr2[i] = Arr1[i];
		}

		System.arraycopy(Arr1, 0, Arr3, 0, Arr1.length);

		Arr4 = Arr1.clone();

		printCopyArray(Arr1, "Arr1:");
		printCopyArray(Arr2, "Arr2:");
		printCopyArray(Arr3, "Arr3:");
		printCopyArray(Arr4, "Arr4:");
	}

	private static void printCopyArray(int[] arr1, String name) {
		System.out.print(name);
		for (int i : arr1) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
