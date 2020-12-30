package com.sangbill.leecode.string;

import java.util.Arrays;

class T1624_maxLengthBetweenEqualCharacters {
    public int maxLengthBetweenEqualCharacters(String s) {
        int index;
        int[] start = new int[26];
        int[] end = new int[26];
        Arrays.fill(start,-1);
        Arrays.fill(end,-1);
        char[] c = s.toCharArray();
        for(int i = 0;i < c.length;i++){
            index = c[i] - 'a';
            if(start[index] == -1){
                start[index] = i;
            }else{
                end[index] = i;
            }
        }

        int max = -1;
        for(int i = 0;i < start.length;i++){
            if(start[i] != -1 && end[i] != -1){
                max = Math.max(max,end[i] - start[i] - 1);
            }
        }
        return max;
    }
}