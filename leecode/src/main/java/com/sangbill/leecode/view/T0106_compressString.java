package com.sangbill.leecode.view;

class T0106_compressString {
    public String compressString(String S) {
        if(S.length() <= 2){
            return S;
        }
        StringBuilder sb = new StringBuilder();
        char[] c = S.toCharArray();
        char pre = c[0];
        int cnt = 1;
        sb.append(pre);
        for(int i = 1;i < c.length;i++){
            if(c[i] == pre){
                cnt++;
            }else{
                sb.append(cnt);
                pre = c[i];
                cnt = 1;
                sb.append(pre);
            }
        }
        sb.append(cnt);
        return (sb.length() < S.length())?sb.toString():S;
    }

    public static void main(String[] args) {
        T0106_compressString su = new T0106_compressString();
        String s = su.compressString("aabcccccaa");
        System.out.println(s);
    }
}