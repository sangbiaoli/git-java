package com.sangbill.leecode.view;
/**
 * 三步问题
 * @author Bill
 *
 */
public class T0801_waysToStep {
    public int waysToStep(int n) {
        int len = Math.max(n+1,3);
        long[] a = new long[len];
        a[0] = 1;
        a[1] = 1;
        a[2] = 2;
        for(int i = 3;i <= n;i++){
            a[i] = (a[i-3]+a[i-2]+a[i-1])%1000000007;
        }
        return (int)a[n];
    }
}