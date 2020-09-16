package com.sangbill.leecode;

/**
 * 整型bit的一些用法
 * @author liqiangbiao
 * 2020年9月16日
 */
public class IntBit {
	
	/**
	 * 返回二进制1的个数
	 */
	public static int bitCount(int i) {
		return Integer.bitCount(i);
	}
	
	/**
	 * 反转二进制
	 */
	public static int reverse(int i) {
		return Integer.reverse(i);
	}
	
	/**
	 * 返回一个数n，满足条件 </br>
	 * 1. n > i  </br>
	 * 2. n = Math.pow(2,m)</br>
	 * 3. n最接近i </br>
	 * 参考ArrayQueue.allocateElements</br>
	 */
	public static int nearBit(int i){
		 i |= (i >>>  1);
         i |= (i >>>  2);
         i |= (i >>>  4);
         i |= (i >>>  8);
         i |= (i >>> 16);
         i++;

         if (i < 0)
             i >>>= 1;
         return i;
	}
	
	/**
	 * 得到数据i的第k位的值
	 * @throws Exception 
	 */
	public static int kthBit(int i,int k) throws Exception{
		if(i < 0)
			throw new Exception("i should not be negsitive");
		return (i & (1 << k)) >> k;
	}
}
