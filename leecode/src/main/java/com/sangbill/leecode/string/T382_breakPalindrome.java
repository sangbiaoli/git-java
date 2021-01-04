package com.sangbill.leecode.string;

class T382_breakPalindrome {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length() <= 1){
            return "";
        }
        boolean b = false;
        char[] c = palindrome.toCharArray();
        for(int i = 0; i < c.length/2;i++){
            if(c[i] != 'a'){
                c[i] = 'a';
                b = true;
                break;
            }
        }
        if(!b){ //纯a
            c[c.length - 1] = 'b';
        }
        return new String(c);
    }
}