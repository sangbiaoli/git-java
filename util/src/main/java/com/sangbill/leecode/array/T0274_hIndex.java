package com.sangbill.leecode.array;

import java.util.Arrays;

/**
 * H 指数
 * @author Bill
 *
 */
public class T0274_hIndex {
    public int hIndex(int[] citations) {
        // 排序（注意这里是升序排序，因此下面需要倒序扫描）
       Arrays.sort(citations);
       // 线性扫描找出最大的 i
       int i = 0;
       while (i < citations.length && citations[citations.length - 1 - i] > i) {
           i++;
       }
       return i;
   }
    
    public static void main(String[] args) {
    	T0274_hIndex su = new T0274_hIndex();
    	System.out.println(su.hIndex(new int[]{11,15}));
	}
}