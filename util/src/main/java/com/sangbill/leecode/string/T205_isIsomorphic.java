package com.sangbill.leecode.string;

public class T205_isIsomorphic {

	public static boolean isIsomorphic(String s, String t) {
        Integer[] diff1 = new Integer[256];
        Integer[] diff2 = new Integer[256];

        int c1;
        int c2;
        for(int i = 0;i < s.length();i++){
            c1 = (int) s.charAt(i);
            c2 = (int)t.charAt(i);
            if(diff1[c1] == null){
                diff1[c1] = c1 - c2;
            }else if(diff1[c1] != c1 - c2){
                return false;
            }

            if(diff2[c2] == null){
                diff2[c2] = c2 - c1;
            }else if(diff2[c2] != c2 - c1){
                return false;
            }
                     
        }
        return true;
    }

	public static void main(String[] args) {
		System.out.println(isIsomorphic("ab","aa"));
	}
}