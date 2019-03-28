package com.sangbill.advanced.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class POJOReflectionTest {
	public static void main(String[] args) {
		try {
			// 加载WorkPOJO,注意这里一定要写全类名，包括包名，因为包名是类名的一部分
			Class pojo = Class
					.forName("com.sangbill.advanced.reflect.WorkerPOJO");
			// 获取域的数组
			Field[] fieldList = pojo.getDeclaredFields();
			// 获取方法的数组
			Method[] methodList = pojo.getDeclaredMethods();

			System.out.println("WorkerPOJO类的所有字段：");
			System.out.println("修饰符" + "\t" + "类型" + "\t"+ "字段名");

			for (int i = 0; i < fieldList.length; i++) {
				Field field = fieldList[i];
				// 用下面的形式获取具体的修饰符
				System.out.println(Modifier.toString(field.getModifiers())+ "\t" + field.getType() + "\t" + field.getName());
			}

			System.out.println();
			System.out.println("WorkerPOJO类的所有方法(不包括annotation修饰的方法)：");

			for (int j = 0; j < methodList.length; j++) {
				Method method = methodList[j];
				// 判断方法是否被Annotation修饰
				boolean methodAnnotation = method.isAnnotationPresent(WorkerPOJOAnnotation.class);

				// 如果被annotation修饰，则过滤掉该方法，即不输出
				if (methodAnnotation) {
					continue;
				}
				// 获取方法参数列表
				Class parameters[] = method.getParameterTypes();

				System.out.print(Modifier.toString(method.getModifiers()) + " "
						+ method.getReturnType() + " " + method.getName()
						+ " (");

				for (int k = 0; k < parameters.length; k++) {
					System.out.print(parameters[k].toString());
				}

				System.out.println(")");
			}
		} catch (ClassNotFoundException exception1) {
			exception1.printStackTrace();
		}
	}

}
