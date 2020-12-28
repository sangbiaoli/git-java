package com.sangbill.leecode.stack;

import java.util.ArrayList;
import java.util.List;

class T1441_buildArray {
    public List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList<>();
        int index = 0;
        int min = Math.min(target[target.length-1],n);
        for(int i = 1;i <= min;i++){
            list.add("Push");
            if(index < target.length && target[index] == i){
                index++;
            }else{
                list.add("Pop");
            }
        }
        return list;
    }
}