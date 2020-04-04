package com.sangbill.test.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Test8 {

	public static void main(String[] args) throws Exception {
		System.out.println((int)'A'+":"+(int)'Z'+":"+(int)'a'+":"+(int)'z');
		String path = "D:\\calcCharNum.txt";
		
		calCharNum(path);
	}

	private static void calCharNum(String path) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader(new File(path)));
		int b;
		int[] low = new int[26];
		int[] high = new int[26];

		while((b = r.read()) != -1){
			char c = (char) b;
			if(c >= 'a' && c <= 'z'){
				low[c-'a']++;
			}else if(c >= 'A' && c <= 'Z'){
				high[c-'A']++;
			}
		}
		r.close();
		System.out.println(low);
		System.out.println(high);
	}
}
