package com.sangbill.leecode.other;

public class T12_intToRoman {


	/**
	 * 	I             1
		V             5
		X             10
		L             50
		C             100
		D             500
		M             1000
	 * @param num
	 * @return
	 */
	public static String intToRoman(int num) {
		StringBuilder sb = new StringBuilder();
		int temp = 0;
		if(num >= 1000){
			temp = num/1000;
			num = num - temp * 1000;
			sb.append(repeat("M",temp));	
		}
		if(num >= 100){
			temp = num/100;
			num = num - temp * 100;
			sb.append(converRoma(temp,"M","D","C"));			
		}
		if(num >= 10){
			temp = num/10;
			num = num - temp * 10;
			sb.append(converRoma(temp,"C","L","X"));			
		}
		if(num >= 0){
			sb.append(converRoma(num,"X","V","I"));			
		}
		return sb.toString();
	}

	private static String converRoma(int num, String nine, String five, String one) {
		StringBuffer sb = new StringBuffer();
		if(num == 9){
			sb.append(one+nine);
		}else if(num >= 5){
			sb.append(five);
			sb.append(repeat(one, num - 5));
		}else if(num == 4){
			sb.append(one+five);
		}else{
			sb.append(repeat(one, num));
		}
		return sb.toString();
	}

	private static String repeat(String string, int num) {
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < num ;i++){
			sb.append(string);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(intToRoman(1994));
	}
}
