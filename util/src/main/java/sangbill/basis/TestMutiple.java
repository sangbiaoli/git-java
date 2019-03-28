package com.sangbill.basis;

public class TestMutiple {
	public static void main(String[] args) {
		testPrintMutipleWithTendence();	
		testPrintMutipleWithOutTendence();	
	}

	private static void testPrintMutipleWithOutTendence() {
		System.out.println("Print mutiple without tendence:");
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				System.out.print(String.format("%d*%d=%2d ", i, j, i * j));
			}
			System.out.println();
		}
	}

	private static void testPrintMutipleWithTendence() {
		System.out.println("Print mutiple with tendence:");
		for (int i = 1; i < 10; i++) {
			printTendence(i);
			for (int j = i; j < 10; j++) {
				System.out.print(String.format("%d*%d=%2d ", i, j, i * j));
			}
			System.out.println();
		}
	}

	private static void printTendence(int i) {
		for (int j = 1; j < i; j++) {
			System.out.print("       ");
		}
	}
}