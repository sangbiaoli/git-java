package com.sangbill.test.algorithm;

public class Test28 {
	public static void reverseWords(char[] s) {
        final int N = s.length;
        if(N == 0)
        	return;
        
        int start = 0;
        for(int i = 0;i < N;i++){
        	if(s[i] == ' '){
        		reverse(s,start,i - 1);
        		start = i + 1;
        	}
        }
        reverse(s, start, N - 1);
        reverse(s, 0, N - 1);
    }

    public static void reverse(char[] s,int start,int end){
    	while(start < end){
    		char temp = s[start];
    		s[start] = s[end];
    		s[end] = temp;
    		start++;
    		end--;
    	}
    }
    
    public static void main(String[] args) {
		char[] s = new char[]{'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
		reverseWords(s);
		System.out.println(s);
	}
}