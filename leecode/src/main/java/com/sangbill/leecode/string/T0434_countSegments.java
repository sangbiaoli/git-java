package com.sangbill.leecode.string;

class T0434_countSegments {
    public int countSegments(String s) {
        int cnt = 0;
        boolean b = false;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != ' '){
                b = true;
            }else{
                if(b){
                    cnt++;
                }
                b = false;
            }
        }
        if(b){
            cnt++;
        }
        return cnt;
    }
}