package com.sangbill.test.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test6 {

	public static void main(String[] args) throws Exception {
		String srcpath = "C:\\Users\\Bill\\Desktop\\pic\\下载.jpg";
		String destpath = "D:\\迅雷下载";

		copyFile(srcpath,destpath);
	}

	private static void copyFile(String srcpath, String destpath) throws Exception {
		File file = new File(srcpath);
		FileInputStream in = new FileInputStream(file);
		String filePath = destpath+"\\"+file.getName();
		FileOutputStream out = new FileOutputStream(new File(filePath));
		int b;
		while((b = in.read()) != -1){
			out.write(b);
		}
		in.close();
		out.close();
	}
}
