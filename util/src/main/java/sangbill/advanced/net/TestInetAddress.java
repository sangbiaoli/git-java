package com.sangbill.advanced.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestInetAddress {
	public static void main(String[] args) {
		testInetAddress();
	}

	private static void testInetAddress() {
		try {
			String ip = InetAddress.getLocalHost().getHostAddress().trim();
			System.out.println(ip);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}	
	}
}
