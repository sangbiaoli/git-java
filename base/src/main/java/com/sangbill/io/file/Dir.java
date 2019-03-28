package com.sangbill.io.file;

import java.io.File;
import java.io.FilenameFilter;

public class Dir {
	public static void main(String[] args) {
		File file = new File("C:");
		FilenameFilter fnf = new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.endsWith(".log");
			}
		};
		String[] names = file.list(fnf);
		for (String name : names)
			System.out.println(name);
	}
}