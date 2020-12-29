package com.sangbill.leecode.string;

class T1576_modifyString {
    public String modifyString(String s) {
        char[] c = s.toCharArray();
        int len = c.length;
        if(len == 1){
            c[0] = (c[0] == '?')?'a':c[0];
        }else{
            //设置第一个元素
            if(c[0] == '?'){
                c[0] = (c[1] == 'a')?'b':'a';
            }
            //设置中间元素
            for(int i = 1;i < len - 1;i++){
                if(c[i] == '?'){
                    char t = 'a';
                    if(c[i-1] == 'a' || c[i+1] == 'a'){
                        t = 'b';
                        if(c[i-1] == 'b' || c[i+1] == 'b'){
                            t = 'c';
                        }
                    }
                    c[i] = t;
                }
            }
            //设置最后一个元素
            if(c[len- 1] == '?'){
                c[len - 1] = (c[len - 2] == 'a')?'b':'a';
            }
        }
        return new String(c);
    }
}