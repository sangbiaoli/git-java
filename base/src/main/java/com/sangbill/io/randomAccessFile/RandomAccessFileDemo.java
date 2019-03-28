package com.sangbill.io.randomAccessFile;

import java.io.FileDescriptor;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("employee.dat", "rw");
		FileDescriptor fd = raf.getFD();
		String str = "abcd我们好";
		// Perform a critical write operation.
		raf.write(str.getBytes());
		// Synchronize with the underlying disk by flushing the operating system
		// output buffers to the disk.
		fd.sync();
		// Perform a non-critical write operation where synchronization isn't
		// necessary.
		raf.write(str.getBytes());
		// Do other work.
		// Close the file, emptying output buffers to the disk.
		raf.close();
	}
}
