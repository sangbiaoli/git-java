package com.sangbill.leecode.string;

class T1392_longestPrefix {
    public String longestPrefix(String s) {
        int n = s.length();
        long prefix = 0, suffix = 0;
        long base = 31, mod = 1000000007, mul = 1;
        int happy = 0;
        for (int i = 1; i < n; ++i) {
            prefix = (prefix * base + (s.charAt(i - 1) - 'a')) % mod;
            suffix = (suffix + (s.charAt(n - i) - 'a') * mul) % mod;
            if (prefix == suffix) {
                happy = i;
            }
            mul = mul * base % mod;
        }
        return s.substring(0, happy);
    }

    public String longestPrefixOfKmp(String s) {
        char[] c = (s + " ").toCharArray();//额外加多一个字符，好计算所有有效的next
        int[] next = new int[c.length];
        int j = 0, k = -1;
        next[0] = -1;
        while (j < c.length - 1) {
            if (k == -1 || c[j] == c[k]) {
                next[++j] = ++k;
            } else {
                k = next[k];
            }
        }
        return s.substring(0, next[next.length - 1]);
    }
}