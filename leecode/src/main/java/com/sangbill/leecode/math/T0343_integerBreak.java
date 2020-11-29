package com.sangbill.leecode.math;
/**
 * 整数拆分
 * 
 * 证明更可能的拆分3
 * @author Bill
 *
 */
public class T0343_integerBreak {
    public int integerBreak(int n) {
       if (n <= 3) {
            return n - 1;
        }
        int quotient = n / 3;
        int remainder = n % 3;
        if (remainder == 0) {
            return (int) Math.pow(3, quotient);
        } else if (remainder == 1) {
            return (int) Math.pow(3, quotient - 1) * 4;
        } else {
            return (int) Math.pow(3, quotient) * 2;
        }
    }
}