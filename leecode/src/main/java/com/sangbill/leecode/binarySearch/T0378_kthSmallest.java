package com.sangbill.leecode.binarySearch;

import java.util.*;

class T0378_kthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int[] row:matrix){
            for(int num:row){
                if(queue.size() == k && num > queue.peek())
                    break;
                queue.add(num);
                if(queue.size() > k){
                    queue.remove();
                }
            }
        }
        return queue.remove();
    }

    public static void main(String[] args) {
        /*int[][] matrix = new int[][]{
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        int k = 8;*/
        /*int[][] matrix = new int[][]{
                {1, 3, 5}, {6, 7, 12}, {11, 14, 14}
        };
        int k = 2;*/
        /*int[][] matrix = new int[][]{
                {1, 2}, {1, 3}
        };
        int k = 2;*/
        int[][] matrix =
                {{1, 3, 5}, {6, 7, 12}, {11, 14, 14}};
        int k = 4;
        T0378_kthSmallest su = new T0378_kthSmallest();
        System.out.println(su.kthSmallest(matrix, k));
    }
}