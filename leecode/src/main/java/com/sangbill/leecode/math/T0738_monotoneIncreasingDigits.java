package com.sangbill.leecode.math;

class T0738_monotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int N) {
        if (N <= 9) {
            return N;
        }
        int[] nums = new int[10];
        int count = 0;
        while (N > 0) {
            nums[count] = N % 10;
            N = N / 10;
            count++;
        }

        for (int i = count; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                int j = i;
                while (j < count && nums[j] == nums[j + 1]) {
                    j++;
                }
                nums[j]--;
                j--;
                while (j >= 0) {
                    nums[j] = 9;
                    j--;
                }
            }
        }

        int rs = 0;
        for (int i = count; i >= 0; i--) {
            rs = rs * 10 + nums[i];
        }
        return rs;
    }

    public static void main(String[] args) {
        T0738_monotoneIncreasingDigits su = new T0738_monotoneIncreasingDigits();
        System.out.println(su.monotoneIncreasingDigits(999899));
    }
}