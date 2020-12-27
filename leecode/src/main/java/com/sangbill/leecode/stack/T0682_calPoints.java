package com.sangbill.leecode.stack;

import java.util.Stack;

class T0682_calPoints {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack();
        int top, newtop;
        for (String op : ops) {
            if (op.equals("+")) {
                top = stack.pop();
                newtop = top + stack.peek();
                stack.push(top);
                stack.push(newtop);
            } else if (op.equals("C")) {
                stack.pop();
            } else if (op.equals("D")) {
                stack.push(2 * stack.peek());
            } else {
                stack.push(Integer.valueOf(op));
            }
        }

        int ans = 0;
        for (int score : stack) ans += score;
        return ans;
    }

    public static void main(String[] args) {
        T0682_calPoints su = new T0682_calPoints();
        su.calPoints(new String[]{"5", "2", "C", "D", "+"});
    }
}