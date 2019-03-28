package com.sangbill.io.wr;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReaderDemo {
	public static void main(String[] args) throws IOException {
		FileInputStream fis;
		fis = new FileInputStream("polish.txt");
		try (InputStreamReader isr = new InputStreamReader(fis, "8859_2")) {
			int ch = isr.read();
			System.out.println(ch);
		}
	}
}
