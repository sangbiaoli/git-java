package com.sangbill.test.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Test4 {

	public static void main(String[] args) {
		String path = "D:\\a.txt";
		readFile(path);
	}

	@SuppressWarnings("resource")
	private static void readFile(String path) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
			String line = null;
			while((line = reader.readLine()) != null){
				System.out.println(line);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
