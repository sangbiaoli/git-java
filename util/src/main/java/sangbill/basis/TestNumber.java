package com.sangbill.basis;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class TestNumber {
	public static void main(String[] args) {
		/*printIntegerConstructor();
		printIntegerConstant();
		printIntegerExchange();
		printStringToInteger();*/
	  NumberFormat format = new DecimalFormat("#0.00");
	  double d = 23421.234245;
	  d = Double.parseDouble(format.format(d));
	  System.out.println(d);
	}

	private static void printIntegerConstructor() {
		Integer integerObj1 = new Integer(5);
		Integer integerObj2 = new Integer("6");
		Integer integerObj3 = Integer.valueOf("7");
		System.out.println(integerObj1.toString());
		System.out.println(integerObj2.toString());
		System.out.println(integerObj3.toString());
	}

	private static void printIntegerConstant() {
		System.out.println("The maximum integer is :" + Integer.MAX_VALUE);
		System.out.println("The minimum integer is :" + Integer.MIN_VALUE);
	}

	private static void printIntegerExchange() {
		int number = 20;
		Integer integerObj = new Integer(number);
		System.out.println(integerObj.toString());
	}

	private static void printStringToInteger() {
		System.out.println(Character.MAX_RADIX);
		System.out.println(Character.MIN_RADIX);
		System.out.println(Integer.parseInt("11", 2));
		System.out.println(Integer.parseInt("35", 6));
	}

}
