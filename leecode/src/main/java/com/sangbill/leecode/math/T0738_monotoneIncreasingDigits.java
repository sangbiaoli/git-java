package com.sangbill.leecode.math;

class T0738_monotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int N) {
        int ones = 111111111;
        int res = 0;
        for (int i = 0; i < 9; i++) {
            while (res + ones > N) {
                ones /= 10;
            }
            res += ones;
            if (ones == 0)
                break;
        }
        return res;
    }

    public static void main(String[] args) {
        T0738_monotoneIncreasingDigits su = new T0738_monotoneIncreasingDigits();
        System.out.println(su.monotoneIncreasingDigits(999899));
    }
}