package com.sangbill.leecode.string;

class T0443_compress {
    public int compress(char[] chars) {
        int cnt = 1;
        char c = chars[0];
        StringBuilder sb = new StringBuilder();
        sb.append(c);
        for(int i = 1;i < chars.length;i++){
            if(chars[i] == c){
                cnt++;
            }else{
                if(cnt > 1){
                    sb.append(cnt);
                }
                c = chars[i];
                sb.append(c);
                cnt = 1;
            }
        }
        if(cnt > 1){
            sb.append(cnt);
        }
        int len = sb.length();
        for(int i = 0;i < chars.length;i++){
            if(i < len){
                chars[i] = sb.charAt(i);
            }else{
                chars[i] = ' ';
            }
        }
        return sb.length();
    }

    public static void main(String[] args) {
        T0443_compress su = new T0443_compress();
        char[] chars = new char[]{'a','a','b','b','c','c','c'};
        int res = su.compress(chars);
        System.out.println(res);
    }
}