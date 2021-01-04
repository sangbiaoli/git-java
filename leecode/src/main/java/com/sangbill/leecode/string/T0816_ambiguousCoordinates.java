package com.sangbill.leecode.string;

import java.util.ArrayList;
import java.util.List;

class T0816_ambiguousCoordinates {

    public List<String> ambiguousCoordinates(String S) {
        List<String> list = new ArrayList<>();
        char[] c = S.substring(1, S.length() - 1).toCharArray();
        int len = c.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j <= i; j++) {
                String pre = getNum(c, 0, j, i);
                if (pre != null) {
                    for (int k = i + 1; k <= len - 1; k++) {
                        String suf = getNum(c, i + 1, k, len - 1);
                        if (suf != null) {
                            list.add("(" + pre + ", "+ suf + ")");
                        }
                    }
                }
            }
        }
        return list;
    }

    private String getNum(char[] c, int start, int k, int end) {
        StringBuilder num = new StringBuilder();
        num.append(c, start, k - start + 1);
        if (k < end) { //有小数
            num.append('.').append(c, k + 1, end - k);
            String temp = num.toString();
            return ((temp.startsWith("0") && !temp.startsWith("0.")) || temp.endsWith("0")) ? null : num.toString();
        } else { //整数
            return (num.charAt(0) == '0' && num.length() > 1) ? null : num.toString();
        }
    }

    public static void main(String[] args) {
        T0816_ambiguousCoordinates su = new T0816_ambiguousCoordinates();
        String s = "(123)";
        List<String> list = su.ambiguousCoordinates(s);
        for (String temp : list) {
            System.out.println(temp);
        }
    }
}