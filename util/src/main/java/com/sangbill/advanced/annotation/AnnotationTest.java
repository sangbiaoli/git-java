package com.sangbill.advanced.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnotationTest {
	public static void main(String[] args) {
		Class pojo;
		try {
			pojo = Class.forName("com.sangbill.advanced.annotation.Apple");
			// 获取域的数组
			Field[] fieldList = pojo.getDeclaredFields();
			for (int i = 0; i < fieldList.length; i++) {
				System.out.println(fieldList[i].getName());
			}
			// 获取方法的数组
			Method[] methodList = pojo.getDeclaredMethods();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
