package com.sangbill.leecode.string;

public class Kmp {
    public static void main(String[] args) {
        String s = "ABCABDABCABCAB";
        int[] next = getNext(s);
        for (int x : next) {
            System.out.print(x + ",");
        }
    }

    private static int[] getNext(String s) {
        char[] c = s.toCharArray();
        int[] next = new int[c.length];
        next[0] = -1;
        int j = 0, k = -1;
        StringBuilder sb = new StringBuilder();
        while (j < c.length - 1) {
            sb.append(String.format("j:%s,k:%s----->", j, k));
            if (k == -1 || c[j] == c[k]) {
                j++;
                k++;
                sb.append(String.format("next[%s] = %s", j, k));
                next[j] = k;
            } else {
                sb.append(String.format("k = next[%s] = %s", k, next[k]));
                k = next[k];
            }
            sb.append("\n");
        }
        System.out.println(sb);
        return next;
    }
}
