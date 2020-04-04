package com.sangbill.test.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Test7 {

	public static void main(String[] args) throws Exception {
		String path = "D:\\calcCharNum.txt";

		calCharNum(path);
	}

	private static void calCharNum(String path) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader(new File(path)));
		int b;
		int[] cnt = new int[2];
		while((b = r.read()) != -1){
			char c = (char) b;
			if(c == 'a'){
				cnt[0]++;
			}else if(c == 'A'){
				cnt[1]++;
			}
		}
		r.close();
		System.out.println(cnt[0]+","+cnt[1]);
	}
}
