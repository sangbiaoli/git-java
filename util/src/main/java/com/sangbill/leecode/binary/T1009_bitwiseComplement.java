package com.sangbill.leecode.binary;
/**
 *  十进制整数的反码
 * @author Bill
 *
 */
class T1009_bitwiseComplement {
    public int bitwiseComplement(int N) {
        if(N==0) return 1;
        int temp = N;
        N = (N>>>1) | N;
        N = (N>>>2)| N;
        N = (N>>>4)| N;
        N = (N>>>8)| N;
        N = (N>>>16)| N;
        return N & (-temp-1);
    }
}