package com.sangbill.advanced.international;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class TestNumberFormat {
	public static void main(String[] args) {
		testInstanceNumberFormat();
		testCurrencyInstanceNumberFormat();
		testPercentInstanceNumberFormat();
		testParseValue();
		testDecimalFormat();
		testDecimalIterateInteger();
	}

	private static void testDecimalIterateInteger() {
		final int NUMBER = 99;
		StringBuffer pattern = new StringBuffer();
		for (int i = 0, length = (NUMBER + "").length(); i < length; i++)
			pattern.append('0');

		DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.US);
		decimalFormat.applyPattern(pattern.toString());
		for (int i = 1; i <= NUMBER; i++) {
			System.out.print(decimalFormat.format(i) + " ");
			if (i % 10 == 0) {
				System.out.println();
			}
		}
	}

	private static void testDecimalFormat() {
		NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
		DecimalFormat decimalFormat = (DecimalFormat) numberFormat;
		decimalFormat.applyPattern("00.00##");
		System.out.println(decimalFormat.format(111.2226));
		System.out.println(decimalFormat.format(1111.2226));
		System.out.println(decimalFormat.format(1.22));
		System.out.println(decimalFormat.format(1));
	}

	private static void testParseValue() {
		NumberFormat currencyFormat = NumberFormat
				.getCurrencyInstance(Locale.US);
		try {
			Number number = currencyFormat.parse("$5,000.56");
			System.out.println(number.doubleValue());
		} catch (Exception e) {
			System.out.println("Parse failed");
		}
	}

	private static void testPercentInstanceNumberFormat() {
		NumberFormat percentFormat = NumberFormat.getPercentInstance(Locale.US);
		System.out.println(percentFormat.format(0.555367));
	}

	private static void testCurrencyInstanceNumberFormat() {
		NumberFormat currencyFormat = NumberFormat
				.getCurrencyInstance(Locale.US);
		System.out.println(currencyFormat.format(5000.555));
	}

	private static void testInstanceNumberFormat() {
		NumberFormat numberFormat = NumberFormat.getInstance(Locale.FRANCE);
		System.out.println(numberFormat.format(5000.555));
	}
}
