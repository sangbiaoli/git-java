package com.sangbill.leecode.stack;

class T1021_removeOuterParentheses {
    public String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        int level = 0;
        for (char c : S.toCharArray()) {
            if (c == ')') --level;
            if (level >= 1) sb.append(c);
            if (c == '(') ++level;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        T1021_removeOuterParentheses su = new T1021_removeOuterParentheses();
        System.out.println(su.removeOuterParentheses("()()"));
    }
}