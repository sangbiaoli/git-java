package com.sangbill.leecode.binarySearch;

class T0069_mySqrt {
    public int mySqrt(int x) {
        int low = 1,high = x,mid,tmp;
        while(low <= high){
            mid = low + (high-low)/2;
            tmp = x/mid ;
            if(tmp == mid){
                return mid;
            }else if(tmp < mid){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low-1;
    }
}