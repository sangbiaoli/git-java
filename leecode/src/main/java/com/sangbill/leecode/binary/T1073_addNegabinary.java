package com.sangbill.leecode.binary;

import java.util.Arrays;

/**
 *  负二进制数相加
 * @author Bill
 *
 */
class T1073_addNegabinary {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
    	if(arr1 == null || arr2 == null)
            return (arr1 == null)?arr2:arr1;

        if(arr1.length == 0 || arr2.length == 0)
            return (arr1.length == 0)?arr2:arr1;

        int len = Math.max(arr1.length,arr2.length);
        int[] arr = new int[len+2];
        int p1 = arr1.length-1;
        int p2 = arr2.length-1;
        int p = arr.length-1;

        int a1 = 0;
        int a2 = 0;
        int carry = 0;
        int sum = 0;
        //本来这里要写成p1 >= 0 || p2 >= 0，但考虑到最高位进一，要算多2个步骤
        while(p1 >= -2 || p2 >=-2 ){
            a1 = (p1 >= 0)?arr1[p1]:0;
            a2 = (p2 >= 0)?arr2[p2]:0;
            sum = a1+a2+carry;
            if(sum>=2){
                carry = -1;
                arr[p] = sum - 2;
            }else if(sum == -1){
                carry = 1;
                arr[p] = 1;
            }else{
                carry = 0;
                arr[p] = sum;
            }
            p1--;
            p2--;
            p--;
        }

        if(arr[0] == 1){
            return arr;
        }else{
            int i = 0;
            for(;i < arr.length;i++){
                if(arr[i] == 1){
                    break;
                }
            }
            if(i == arr.length){
                i--;
            }
            return Arrays.copyOfRange(arr,i,arr.length);
        }
    }
    
    public static void main(String[] args) {
    	/*int[] a = new int[]{1,1,1,1,1};
    	int[] b = new int[]{1,0,1};
    	Solution su = new Solution();
    	int[] c = su.addNegabinary(a, b);*/
    	
    	int[] arr = new int[]{0, 0, 0, 0, 0, 0, 0};
    	int i = arr.length;
    	int[] c = Arrays.copyOfRange(arr,i,arr.length);
    	System.out.println(c);
	}
}