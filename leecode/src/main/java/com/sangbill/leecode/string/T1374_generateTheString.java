package com.sangbill.leecode.string;

class T1374_generateTheString {
    public String generateTheString(int n) {
        char[] c = new char[n];
        int i = 0;
        if(n % 2 == 0){
            c[i] = 'z';
            i++;
        }
        while(i < n){
            c[i++] = 'a';
        }
        return new String(c);
    }
}