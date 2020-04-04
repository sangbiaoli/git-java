package com.sangbill.test.io;

import java.io.File;
import java.io.IOException;

public class Test1 {
	
	public static void main(String[] args) {
		File file = new File("D:\\HelloWorld.txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("file:"+file.isFile());
		System.out.println("directory:"+file.isDirectory());

		
		File d = new File("D:\\IOTest");
		d.mkdir();
		File newFile = new File(d.getAbsolutePath()+"\\"+file.getName());
		file.renameTo(newFile);
		
		File[] files = d.listFiles();
		for (int i = 0; i < files.length; i++) {
			if(files[i].isFile()){
				System.out.println(files[i].getName());
			}
		}	
	}
}
