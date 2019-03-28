package com.sangbill.io.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copy {
	public static void main(String[] args) {

		String src = "a.txt";
		String desc = "b.txt";
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(src);
			fos = new FileOutputStream(desc);
			int b; // I chose b instead of byte because byte is a reserved
			// word.
			while ((b = fis.read()) != -1)
				fos.write(b);
		} catch (FileNotFoundException fnfe) {
			System.err.println(
					args[0] + " could not be opened for input, or " + args[1] + " could not be created for output");
		} catch (IOException ioe) {
			System.err.println("I/O error: " + ioe.getMessage());
		} finally {
			if (fis != null)
				try {
					fis.close();
				} catch (IOException ioe) {
					assert false; // shouldn't happen in this context
				}
			if (fos != null)
				try {
					fos.close();
				} catch (IOException ioe) {
					assert false; // shouldn't happen in this context
				}
		}
	}
}