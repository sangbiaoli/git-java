package com.sangbill.test.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Test5 {

	public static void main(String[] args) {
		String path = "D:\\Hello.txt";
		writeFile(path);
	}

	@SuppressWarnings("resource")
	private static void writeFile(String path) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(path)));
			writer.write("HelloJavaWorld你好世界");
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
