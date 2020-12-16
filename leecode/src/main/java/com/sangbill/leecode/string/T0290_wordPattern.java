package com.sangbill.leecode.string;

import java.util.HashMap;
import java.util.Map;

class T0290_wordPattern {
    public boolean wordPattern(String pattern, String s) {
        char[] chars = pattern.toCharArray();
        String[] strs = s.split(" ");
        if(chars.length != strs.length){
            return false;
        }
        Map<Character,String> keyMap = new HashMap();
        Map<String,Character> valueMap = new HashMap();
        Character key = null;
        String value = null;
        for(int i = 0;i < chars.length;i++){
            key = chars[i];
            value = strs[i];
            if(keyMap.containsKey(key) && !keyMap.get(key).equals(value)){
                return false;
            }
            if(valueMap.containsKey(value) && !valueMap.get(value).equals(key)){
                return false;
            }
            keyMap.put(key,value);
            valueMap.put(value,key);
        }
        return true;
    }
}