package com.sangbill.leecode.binarySearch;

class T0275_hIndex {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int mid, low = 0, high = n - 1;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (citations[mid] == n - mid){
                return n - mid;
            }else if (citations[mid] < n - mid){
                low = mid + 1;
            } else{
                high = mid - 1;
            }
        }
        return n - low;
    }

    public static void main(String[] args) {
//        int[] citations = new int[]{0,1,3,5,6};
        int[] citations = new int[]{11,15};
        T0275_hIndex su = new T0275_hIndex();
        System.out.println(su.hIndex(citations));
    }
}