package com.sangbill.basis;

import java.util.List;
import java.util.Random;

public class TestRandom {
	public static void main(String[] args) {
		/*List<String> listString = Arrays.asList("a","b","c","d","e","f");
		List<Integer> listInt = Arrays.asList(1,2,3,4,5,6,7);
		for (int i = 0; i < listString.size(); i++) {	
			System.out.print(getRandomElment(listString).toString()+",");
		}
		System.out.println("");
		for (int i = 0; i < listInt.size(); i++) {	
			System.out.print(getRandomElment(listInt).toString()+",");
		}*/
		Random r = new Random();
		for (int i = 0; i < 60; i++) {			
			System.out.println(getRandomIpAddress());
			
		}
	}
	private static String getRandomMac() {
		String str = "00:26:cb:95:ca:a1";
		String s = "1234567890abcdef";
		int sLength = s.length();
		Random r = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 6; i++) {
			sb.append(s.charAt(r.nextInt(sLength))).append(s.charAt(r.nextInt(sLength))+":");
		}
		sb.append(s.charAt(r.nextInt(sLength))).append(s.charAt(r.nextInt(sLength)));
		return sb.toString();
	}
	private static String getRandomIp() {
		String[] pre = {"131.83","150.36"};
		Random r = new Random();
		StringBuffer sb = new StringBuffer();
		sb.append(pre[r.nextInt(2)]);
		sb.append("."+r.nextInt(256));
		sb.append("."+r.nextInt(256));
		return sb.toString();
	}
	
	private static String getRandomIpAddress(){  
        return new Random().nextInt(254)+"."+new Random().nextInt(254)+"."+new Random().nextInt(254)+"."+new Random().nextInt(254);  
    }  
	 
	private static <T> T getRandomElment(List<T> list) {
		if(list != null && list.size() >0){
			Random r = new Random();
			return list.get(r.nextInt(list.size()));
		}
		return null;		
	}	
}
