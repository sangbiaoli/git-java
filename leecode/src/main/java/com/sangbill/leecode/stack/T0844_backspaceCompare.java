package com.sangbill.leecode.stack;

import java.util.Stack;

class T0844_backspaceCompare {
    public boolean backspaceCompare(String S, String T) {
        String s = backspace(S);
        String t = backspace(T);
        return s.equals(t);
    }

    public String backspace(String S){
        Stack<Character> stack = new Stack();
        for(char c:S.toCharArray()){
            if(c == '#'){
                if(stack.size() > 0){
                    stack.pop();
                }
            }else{
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(Character c:stack){
            sb.append(c);
        }
        return sb.toString();
    }
}