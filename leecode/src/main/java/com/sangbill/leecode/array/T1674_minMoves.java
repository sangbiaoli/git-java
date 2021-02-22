package com.sangbill.leecode.array;

public class T1674_minMoves {

   public int minMoves(int[] nums,int limit){
      int n = nums.length;
      int[] delta = new int[limit * 2 + 2];
      for (int i = 0; i < n / 2; ++i) {
         int lo = 1 + Math.min(nums[i], nums[n - i - 1]);
         int hi = limit + Math.max(nums[i], nums[n - i - 1]);
         int sum = nums[i] + nums[n - i - 1];
         delta[lo]--;
         delta[sum]--;
         delta[sum + 1]++;
         delta[hi + 1]++;
      }
      int now = n;
      int ans = n;
      for (int i = 2; i <= limit * 2; ++i) {
         now += delta[i];
         ans = Math.min(ans, now);
      }
      return ans;
   }

   public static void main(String[] args) {
      T1674_minMoves su = new T1674_minMoves();
      int[] nums = {2,7,11,48,29,5,12,4,27,55,57,33,45,49,33,32,26,29,39,4,13,24,48,47,3,24,56,57,28,50,4,8,34,46,44,47,44,27,56,30,16,20,34,35,57,57,17,9,25,16,28,44};
      int limit = 57;
      int res = su.minMoves(nums,limit);
      System.out.println(res);
   }

}