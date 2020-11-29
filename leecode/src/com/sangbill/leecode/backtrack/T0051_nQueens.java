package com.sangbill.leecode.backtrack;

import java.util.ArrayList;
import java.util.List;

public class T0051_nQueens {

	public static List<List<String>> solveNQueens(int n) {	
		List<List<String>> list = new ArrayList<List<String>>();
		int[] array = new int[n];
		if(n == 1){
			array[0] = 0;			
			print(array, list);
		}else{
			for (int i = 0; i < n; i++) {
				array[0] = i;			
				back(array,1,n,list);				
			}
		}
		
        return list;
    }
	/**
	 * 第row行设置，并用追溯法判断是否出现冲突
	 * @param array
	 * @param row
	 * @param n
	 * @param list
	 */
	private static void back(int[] array, int row, int n,List<List<String>> list) {
		for(int i = 0;i < n;i++){
			if(check(array,row,i)){
				array[row] = i;
				if(row == n - 1){
					print(array,list);
				}else{
					back(array,row + 1,n,list);
				}
			}
		}		
	}
	
	private static void print(int[] array,List<List<String>> list) {
		int n = array.length;
		List<String> temp = new ArrayList<String>(n);
		for (int i = 0; i < array.length; i++) {
			StringBuffer sb = new StringBuffer();
			for(int j = 0;j < array[i];j++){
				sb.append(".");
			}
			sb.append("Q");
			for(int j = array[i] + 1;j <n;j++){
				sb.append(".");
			}
			temp.add(sb.toString());
		}
		list.add(temp);
	}

	/**
	 * 检查是否重列或斜对角
	 * @param array
	 * @param row
	 * @param value
	 * @return
	 */
	private static boolean check(int[] array, int row, int value) {
		for(int i = 0;i < row;i++){
			if(array[i] == value || Math.abs(row - i) == Math.abs(array[i] - value)){
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(solveNQueens(6));
	}
}
