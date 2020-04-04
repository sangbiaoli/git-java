package com.sangbill.test.io;

import java.io.File;

public class Test2 {
	
	public static void main(String[] args) {
		String path = "D:\\迅雷下载";
		recursiveFile(path);
	}

	private static void recursiveFile(String path) {
		File file = new File(path);
		System.out.println(file.getAbsolutePath());
		if(file.isDirectory()){
			File[] list = file.listFiles();
			for (int i = 0; i < list.length; i++) {
				recursiveFile(list[i].getPath());
			}
		}
		
	}
}
