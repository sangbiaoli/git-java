package com.sangbill.leecode.array;

class T1122_relativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] tmp = new int[1001];
        for (int num : arr1) {
            tmp[num]++;
        }
        int pos = 0;      //arr1中索引的位置 也是arr2中含有的数字在arr1中的最大长度
        for (int num : arr2) {
            while (tmp[num] > 0) {
                arr1[pos++] = num;
                tmp[num]--;
            }
        }
        //int check=pos;  这里是arr2中没有的值开始的位置。
        for (int i = 0; i < 1001; ++i) {
            while (tmp[i] > 0) {
                arr1[pos++] = i;
                tmp[i]--;
            }
        }
        //Arrays.sort(arr1,check,n);   不需要排序  计数排序在数组中遍历时已经是有序的了。谢谢提醒
        return arr1;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = new int[]{2, 1, 4, 3, 9, 6};

        T1122_relativeSortArray su = new T1122_relativeSortArray();
        int[] rs = su.relativeSortArray(arr1, arr2);
        System.out.println(rs.length);
    }
}