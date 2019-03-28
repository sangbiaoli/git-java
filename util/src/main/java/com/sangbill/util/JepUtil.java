package com.sangbill.util;

import org.nfunk.jep.JEP;

public class JepUtil {
	/**
	 * 计算表达式，true为1，false为0
	 * @author liqiangbiao
	 * @param expression_in
	 * @return
	 */
	public static double getExpressValue(String  expression_in){
		JEP myPrase = new JEP();  
		myPrase.parseExpression(expression_in);  
		return myPrase.getValue();
	}
}
