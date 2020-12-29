package com.sangbill.leecode.string;

class T0459_repeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for (int gap = 1; gap <= len / 2; gap++) {
            if (len % gap == 0) {
                boolean b = true;
                String repeat = s.substring(0, gap);//基本字符串
                for (int j = 1; j < len / gap; j++) {
                    String temp = s.substring(j * gap, (j + 1) * gap);
                    if (!repeat.equals(temp)) {
                        b = false;
                        break;
                    }
                }
                if (b) {
                    return b;
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        String s = "abcabcabcabc";
        T0459_repeatedSubstringPattern su = new T0459_repeatedSubstringPattern();
        System.out.println(su.repeatedSubstringPattern(s));
    }
}