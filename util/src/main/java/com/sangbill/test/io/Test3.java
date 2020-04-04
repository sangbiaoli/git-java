package com.sangbill.test.io;

import java.io.File;
import java.io.FileFilter;

public class Test3 {
	static FileFilter filter = new FileFilter() {
		@Override
		public boolean accept(File file) {
			return file.isDirectory() || (file.isFile() && file.getName().endsWith(".java"));
		}
	};
	
	public static void main(String[] args) {
		File file = new File("");
		recursiveFile(file.getAbsolutePath());
	}

	private static void recursiveFile(String path) {
		File file = new File(path);
		if(file.isDirectory()){
			File[] list = file.listFiles(filter);
			for (int i = 0; i < list.length; i++) {
				recursiveFile(list[i].getPath());
			}
		}else{
			System.out.println(file.getAbsolutePath());
		}
	}
}
