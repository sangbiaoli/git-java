package com.sangbill.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 
 * @author bill
 *
 */
public class MixedUtil {
	/**
	 * 测试统计年龄段数据
	 * @author liqiangbiao
	 */
	public static void testAgeCount(){
		int[][] m = {{0,0,0,0,0},{0,0,0,0,0}};//10-29,30-39,40-49,50-59,60-100
		Random r = new Random();
		for (int i = 0; i < 10; i++) {
			int gener = r.nextInt(2);
			int age = r.nextInt(100);
			int j = age / 10;
			if(j<3 && j>0){	//10-29
				m[gener][0]++;
			}else if(j > 5){ //60-100
				m[gener][m[0].length-1]++;
			}else{
				m[gener][j-2]++;   //其他
			}
			if(gener == 0){				
				System.out.println("@@"+gener+"-"+age+"-"+j);
			}else{
				System.out.println("%%"+gener+"-"+age+"-"+j);
			}
		}
		System.out.println("@@@@@@@@@");
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j]+",");
			}
			if(i == 0){
				System.out.println("\n%%%%%%%%");				
			}
		}
	}
	/**
	 * 测试数据是否存在连续三个以上相等或形成等差数列
	 * @param num
	 */
	public static boolean testContinus(int num){
		if(num < 100)
			return false;
		List<Integer> list = new ArrayList<Integer>();
		while(num > 9){
			int n = num % 10;
			num = (num - n)/10;
			list.add(n);
		}
		list.add(num);
		int n1;
		int n2;
		int n3;
		for (int i = 0; i < list.size() - 2 ; i++) {
			n1 = list.get(i);
			n2 = list.get(i+1);
			n3 = list.get(i+2);
			if((n1 == n2 && n2 == n3) || ((n1 + n3) == (n2 + n2) && Math.abs((n1-n3)) == 2)){
				return false;
			}
		}
		return true;
	}
}
