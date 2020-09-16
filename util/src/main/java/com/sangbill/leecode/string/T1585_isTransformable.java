package com.sangbill.leecode.string;

import java.util.Arrays;

public class T1585_isTransformable {

	public boolean isTransformable(String s, String t) {
		char[] sc = s.toCharArray();
		char[] tc = t.toCharArray();
		int i = sc.length - 1;
		while(i >= 0){
			while(i >= 0 && sc[i] == tc[i]){
				i--;
			}
			if(i >= 0){  //字符不等，从sc中继续往回找
				for(int j = i;j >= 0;j--){
					if(sc[j] == tc[i]){
						Arrays.sort(sc, j, i+1);
						break;
					}
				}
				//排完序后仍然不等，则返回false
				if(sc[i] != tc[i]){
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		T1585_isTransformable t = new T1585_isTransformable();
		System.out.println(t.isTransformable("34521", "23415"));
	}
}