package com.sangbill.basis;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TestFindSameNumber {
	
	public static void main(String[] args) {
		findTheSameNumber();
	}

	public static void findTheSameNumber() {
		BufferedReader br1 = null;
		BufferedReader br2 = null;
		try {
			br1 = new BufferedReader(new FileReader("number1.txt"));
			br2 = new BufferedReader(new FileReader("number2.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		ArrayList<String> al = new ArrayList<String>();
		String input;
		try {
			while ((input = br1.readLine()) != null) {
				al.add(input.trim());
			}
			while ((input = br2.readLine()) != null) {
				if (al.contains(input.trim())) {
					System.out.println(input.trim());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br1.close();
				br2.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
