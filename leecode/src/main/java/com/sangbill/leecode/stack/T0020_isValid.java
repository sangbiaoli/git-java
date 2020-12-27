package com.sangbill.leecode.stack;

import java.util.Stack;

class T0020_isValid {
    public boolean isValid(String s) {
        char[] c = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i < c.length;i++){
            if(c[i] == '(' || c[i] == '{' || c[i] == '['){
                stack.push(c[i]);
                continue;
            }
            if(stack.size() == 0){
                return false;
            }
            char p = stack.pop();
            if((p == '(' && c[i] != ')') || (p == '[' && c[i] != ']') || (p == '{' && c[i] != '}')){
                return false;
            }
        }
        return stack.size() == 0;
    }
}