package com.sangbill.leecode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class T0187_findRepeatedDnaSequences {
	public static List<String> findRepeatedDnaSequences(String s) {
		final int LEN = 10;
        List<String> list = new ArrayList<>();
        if(s.length() < 10)
            return list;

        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i < s.length() - LEN + 1;i++){
            String key = s.substring(i,i+LEN);
            if(map.containsKey(key)){
                map.put(key,map.get(key)+1);
            }else{
                map.put(key,1);
            }
        }

        Iterator<String> it = map.keySet().iterator();
        while(it.hasNext()){
            String key = it.next();
            if(map.get(key) > 1){
                list.add(key);
            }
        }
        return list;
    }
    
    public static void main(String[] args) {
//    	String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
    	String s = "AAAAAAAAAAA";
    	List<String> list = findRepeatedDnaSequences(s);
		System.out.println(list);
	}
}
