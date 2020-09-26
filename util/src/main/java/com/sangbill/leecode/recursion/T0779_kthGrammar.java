package com.sangbill.leecode.recursion;

/**
 * 第K个语法符号
 * 规律，第 K 个数字是上一行第 (K+1) / 2 个数字生成的。
 * 如果上一行的数字为 0，被生成的数字为 1 - (K%2)，
 * 如果上一行的数字为 1，被生成的数字为 K%2。0000000000000
 * .
 * 
 * @author Bill
 *
 */
public class T0779_kthGrammar {
	public int kthGrammar(int N, int K) {
		if (N == 1)
			return 0;
		return (~K & 1) ^ kthGrammar(N - 1, (K + 1) / 2);
	}
	
	public static void main(String[] args) {
		T0779_kthGrammar grammar = new T0779_kthGrammar();
		grammar.kthGrammar(5, 5);
	}
}