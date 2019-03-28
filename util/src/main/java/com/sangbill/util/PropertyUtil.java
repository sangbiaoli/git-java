package com.sangbill.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * @author
 * @version 2008.11.14
 */
public class PropertyUtil {
	// 属性文件的路径
	public final static String FILE_PATH = "/test.properties";
	/**
	 * 采用静态方法
	 */
	private static Properties props = new Properties();
	static {
		loadProp(FILE_PATH);		
	}
	/**
	 * @param properties
	 * @return 
	 */
	private static void loadProp(String properties){
		props = new Properties();
		InputStreamReader in = null;
		try {
			in = new InputStreamReader(PropertyUtil.class.getResourceAsStream(properties), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		try {
			props.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 读取属性文件中相应键的值
	 * 
	 * @param key
	 *            主键
	 * @return String
	 */
	public static String getKeyValue(String key) {
		return props.getProperty(key);
	}
}