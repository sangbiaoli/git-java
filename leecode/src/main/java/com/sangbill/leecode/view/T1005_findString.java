package com.sangbill.leecode.view;

class T1005_findString {
    public int findString(String[] words, String s) {
        int[] nums = new int[words.length];
        int low = 0,mid = 0,high = words.length-1;
        while(low <= high){
            mid = low + (high - low)/2;
            int temp = mid;
            while(mid <= high && words[mid].equals("")){
                mid++;
            }
            if(mid == high+1){
                high = temp-1;
                continue;
            }

            if(words[mid].equals(s)){
                return mid;
            }else if(words[mid].compareTo(s) > 0){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
}