package com.sangbill.leecode.stack;


class T1544_makeGood {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c:s.toCharArray()){
            if(sb.length() == 0){
                sb.append(c);
            }else{
                char p = sb.charAt(sb.length() - 1);
                if(Math.abs(p - c) == 32){
                    sb.deleteCharAt(sb.length() - 1);
                }else{
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}