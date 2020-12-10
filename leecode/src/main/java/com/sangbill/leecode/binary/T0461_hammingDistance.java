package com.sangbill.leecode.binary;

class T0461_hammingDistance {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x^y);
    }
}