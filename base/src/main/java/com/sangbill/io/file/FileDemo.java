package com.sangbill.io.file;

import java.io.File;
import java.io.IOException;

public class FileDemo {
	public static void main(String[] args) throws IOException {
//		createFile();
//		storedPath();
		cdFile();
	}

	private static void cdFile() {
		System.out.println("file.mkdirs() ： "+new File("D:\\abc\\").mkdirs());;
		File file = new File("D:\\abc\\test.txt");
		System.out.println("file.mkdir() ： "+file.mkdirs());;
	}

	private static void storedPath() throws IOException {
		File file = new File("..\\src\\test1.txt");
		System.out.println(file.getPath());
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getCanonicalPath());
		
		System.out.println(new File("D://test1.txt").isAbsolute());
		System.out.println(new File("test1.txt").isAbsolute());

	}

	private static void createFile() {
		File file1 = new File("a.txt");
		File file2 = new File("D://", "b.txt");
		File file3 = new File(new File("D://"), "c.txt");
	}
}
