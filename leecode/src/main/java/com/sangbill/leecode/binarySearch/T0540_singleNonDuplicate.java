package com.sangbill.leecode.binarySearch;

class T0540_singleNonDuplicate {
    public int singleNonDuplicate(int[] nums) {
        int low = 0,high = nums.length-1,mid = 0;
        boolean odd;
        while(low < high){
            mid = (high+low)/2;
            odd = (mid - low)%2 == 0;
            if(nums[mid] == nums[mid-1]){
                if(odd){
                    high = mid - 2;
                }else{
                    low = mid + 1;
                }
            }else if(nums[mid] == nums[mid+1]){
                if(odd){
                    low = mid + 2;
                }else{
                    high = mid - 1;
                }
            }else{
                return nums[mid];
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
        T0540_singleNonDuplicate su = new T0540_singleNonDuplicate();
        int[] nums = new int[]{1,1,2,2,3};
        System.out.println(su.singleNonDuplicate(nums));
    }
}