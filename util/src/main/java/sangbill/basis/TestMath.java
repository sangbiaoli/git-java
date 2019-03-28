package com.sangbill.basis;

public class TestMath {
	public static void main(String[] args) {
		printTrigonmetric();

		printExponent();

		printInterger();

		printComplex();
	}

	// Math complex method锛堢患鍚堢殑璁＄畻锛�	
	private static void printComplex() {
		System.out.println("Math complex method:");
		print(Math.max(2, 3));
		print(Math.min(2, 3));
		print(Math.abs(-2));
		System.out.println();
	}

	private static void print(double result) {
		System.out.println(result);
	}

	// Math getInteger method(鍙栨暣)
	private static void printInterger() {
		System.out.println("Math getInteger method:");

		System.out.println("ceil:");
		print(Math.ceil(2.1));
		print(Math.ceil(2.0));
		print(Math.ceil(-2.0));
		print(Math.ceil(-2.1));

		System.out.println("floor");
		print(Math.floor(2.1));
		print(Math.floor(2.0));
		print(Math.floor(-2.1));
		print(Math.floor(-2.0));

		System.out.println("rint");
		print(Math.rint(2.1));
		print(Math.rint(2.0));
		print(Math.rint(2.6));
		print(Math.rint(-2.5));

		System.out.println("round");
		print(Math.round(2.6f));
		print(Math.round(2.0));
		print(Math.round(-2.0f));
		print(Math.round(-2.6));

		System.out.println();
	}

	// Math exponent method(鎸囨暟鍑芥暟)
	private static void printExponent() {
		/**
		 * 渚濇鏄痚鐨�娆℃柟锛屼互e涓哄簳log3,2鐨�娆℃柟锛�鐨勫紑鏂�		 */
		System.out.println("Math exponent method:");
		print(Math.exp(2));
		print(Math.log(3));
		print(Math.pow(2, 3));
		print(Math.sqrt(4));
		System.out.println();
	}

	// Math trigonometric method(涓夎鍑芥暟)
	private static void printTrigonmetric() {
		System.out.println("Math trigonometric method:");
		print(Math.sin(0));
		print(Math.sin(Math.toRadians(270)));
		print(Math.sin(Math.PI / 6));
		print(Math.sin(Math.PI / 2));
		System.out.println();
	}
}
