package com.sangbill.leecode.string;

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
				char max = tc[i];
				for(int j = i;j >= 0;j--){
					if(max < sc[j]){
						max = sc[j];
					}
					if(sc[j] == tc[i]){
						if(max != sc[j]){
							return false;
						}else{  //把sc[j]这个移到i位置
							for(int k = j;k < i;k++){
								sc[k] = sc[k+1];
							}
							sc[i] = tc[i];
						}
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