package com.sangbill.leecode.string;
import java.util.Stack;

class T0032_longestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s.length() <= 1) {
            return 0;
        }
        char[] c = s.toCharArray();
        int[] left = new int[c.length / 2];
        int[] right = new int[c.length / 2];
        Stack<Integer> stack = new Stack<>();
        int index = -1, max = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '(') {
                stack.push(i);
                continue;
            }
            if (stack.size() > 0) {
                if (index == -1) { //第一次
                    ++index;
                    left[index] = stack.pop();
                    right[index] = i;
                } else {
                    int temp = stack.pop();
                    if (temp + 1 == left[index]) { //匹配这个模式(())，合并
                        left[index] = temp;
                        right[index] = i;
                    } else if (right[index] + 1 == temp) { //匹配这个模式()()，合并
                        right[index] = i;
                    } else {   //不匹配这两种，则新加一堆
                        ++index;
                        left[index] = temp;
                        right[index] = i;
                    }
                }
                //做()()的合并
                while (index > 0) {
                    if (right[index - 1] + 1 == left[index]) {
                        right[index - 1] = right[index];
                        --index;
                    } else {
                        break;
                    }
                }
                max = Math.max(max, right[index] - left[index] + 1);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        T0032_longestValidParentheses su = new T0032_longestValidParentheses();
        System.out.println(su.longestValidParentheses("()(())"));
    }
}