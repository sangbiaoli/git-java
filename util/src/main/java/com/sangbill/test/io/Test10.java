package com.sangbill.test.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Test10 {

	public static void main(String[] args) throws Exception {
		String path = "D:\\calcCharNum.txt";

		reverseRead(path);
	}

	private static void reverseRead(String path) {
		// 要读取的文件的地址
		File file = new File(path);
		try {
			RandomAccessFile raf = new RandomAccessFile(file, "r");
			long length = raf.length();
			StringBuffer sb = new StringBuffer();
			while (length > 0) {
				length--;
				raf.seek(length);
				int c = (char) raf.readByte();
				// 如果asc码<=255,>=0,则判断是个英文字符,添加到字符串中.
				if (c >= 0 && c <= 255) {
					sb.append((char) c);
				} else {
					// 如果不在asc码范围内,则判断是个汉字字符
					// 汉字字符是占2个字节的,所以length再退一个字节
					length--;
					raf.seek(length);
					byte[] cc = new byte[2];
					// cc被复制为文件中连续的两个字节
					raf.readFully(cc);
					sb.append(new String(cc,"UTF-8"));
				}
			}
			System.out.println(sb);
			raf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
