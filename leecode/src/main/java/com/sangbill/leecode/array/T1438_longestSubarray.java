package com.sangbill.leecode.array;

class T1438_longestSubarray {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        int[] maxQueue = new int[n], minQueue = new int[n];
        int maxHead = 0, maxTail = -1, minHead = 0, minTail = -1;
        int l = 0, r = 0;

        int res = 0;
        while(r < n){
            while(maxHead <= maxTail && nums[maxQueue[maxTail]] < nums[r])  maxTail--;
            while(minHead <= minTail && nums[minQueue[minTail]] > nums[r])  minTail--;
            maxQueue[++maxTail] = r;
            minQueue[++minTail] = r;
            r++;
            while(nums[maxQueue[maxHead]] - nums[minQueue[minHead]] > limit){
                l++;
                if(l > maxQueue[maxHead])   maxHead++;
                if(l > minQueue[minHead])   minHead++;
            }
            res = Math.max(res, r - l);
        }
        return res;
    }

    public static void main(String[] args) {
        T1438_longestSubarray su = new T1438_longestSubarray();
/*        int[] nums = {4,2,2,2,4,4,2,2};
        int limit = 0;*/
        int[] nums = {8,2,4,7};
        int limit = 4;
//        int[] nums = {10,1,2,4,7,2};
//        int limit = 5;

/*        int[] nums = {1,5,6,7,8,10,6,5,6};
        int limit = 4;*/
        int res = su.longestSubarray(nums,limit);
        System.out.println(res);
    }
}