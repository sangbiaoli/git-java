package com.sangbill.leecode.string;

class T0032_longestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s.length() <= 1) {
            return 0;
        }
        char[] c = s.toCharArray();
        int left = 0, right = 0, max = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                max = Math.max(max, left * 2);
            }
            if (left < right) {
                left = 0;
                right = 0;
            }
        }

        left = 0;
        right = 0;
        for (int i = c.length - 1; i >= 0; i--) {
            if (c[i] == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                max = Math.max(max, left * 2);
            }
            if (left > right) {
                left = 0;
                right = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        T0032_longestValidParentheses su = new T0032_longestValidParentheses();
        System.out.println(su.longestValidParentheses("()(())"));
    }
}