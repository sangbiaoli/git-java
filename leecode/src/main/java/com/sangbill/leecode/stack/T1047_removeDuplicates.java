package com.sangbill.leecode.stack;

class T1047_removeDuplicates {
    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();
        for(char c:S.toCharArray()){
            if(sb.length() == 0){
                sb.append(c);
            }else{
                if(sb.charAt(sb.length() - 1) == c){
                    sb.deleteCharAt(sb.length() - 1);
                }else{
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}