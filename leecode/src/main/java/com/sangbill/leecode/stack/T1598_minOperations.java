package com.sangbill.leecode.stack;

class T1598_minOperations {
    public int minOperations(String[] logs) {
        int level = 0;
        for(String s:logs){
            if(s.equals("../")){
                if(level > 0){
                    level-- ;
                }
            }else if(s.equals("./")){
                continue;
            }else{
                level++;
            }
        }
        return level;
    }
}