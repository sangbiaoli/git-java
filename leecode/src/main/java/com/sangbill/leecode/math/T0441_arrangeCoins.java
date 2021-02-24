package com.sangbill.leecode.math;

class T0441_arrangeCoins {
    public int arrangeCoins(int n) {
        return (int) (-1 + Math.sqrt(1 + 8 * (long) n)) / 2;
    }

    public static void main(String[] args) {
        T0441_arrangeCoins su = new T0441_arrangeCoins();
        for (int i = 0; i <= 50; i++) {
            System.out.println(String.format("%s:%s", i, su.arrangeCoins(i)));
        }
    }
}