package com.sangbill.io.wr;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class WriterDemo {

	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("polish.txt");
		try(OutputStreamWriter osw = new OutputStreamWriter(fos, "8859_2")){			
			char ch = '\u0323'; // Accented N.
			osw.write(ch);
		}
	}
}
