package com.sangbill.leecode.string;

class T249_minRemoveToMakeValid {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int left = 0,right = 0;
        char c;
        for(int i = 0;i < s.length();i++){
            c = s.charAt(i);
            if(c == ')'){
                if(left > 0){
                    sb.append(c);
                    left--;
                }
            }else if(c == '('){
                left++;
                sb.append(c);
            }else{
                sb.append(c);
            }
        }
        for(int i = sb.length() - 1;i >= 0 ;i--){
             c = sb.charAt(i);
            if(c == ')'){
                right++;
            }else if(c == '('){
                if(right > 0){
                    right--;
                }else{
                    sb.deleteCharAt(i);
                }
            }
        }
        return sb.toString();
    }
}