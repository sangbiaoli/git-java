package com.sangbill.leecode.string;

class T0917_reverseOnlyLetters {
    public String reverseOnlyLetters(String S) {
        if(S.length() <= 1){
            return S;
        }
        char[] c = S.toCharArray();
        int len = c.length;
        int left = 0,right = len - 1;
        while(left <= right){
            while(left <= right && !Character.isLetter(c[left])){
                left++;
            }
            while(left <= right && !Character.isLetter(c[right])){
                right--;
            }
            if(left <= right){
                char tmp = c[left];
                c[left] = c[right];
                c[right] = tmp;
                left++;
                right--;
            }
        }
        return new String(c);
    }
}