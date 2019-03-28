package com.sangbill.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class ResourceUtils {
	/**
	 * 读取resource目录下的文件列表
	 */
	public static void readFolder() {
		String filePath = ResourceUtils.class.getClassLoader().getResource("logs").getPath();
		File file = new File(filePath);
		if(file.isDirectory()){
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				System.out.println(files[i].getName());
			}
		}
		
	}
	/**
	 * 读取resource目录下的文件
	 * @return 
	 */
	public static List<String> readFileForList(String fileName) {
		String filePath = ResourceUtils.class.getClassLoader().getResource(fileName).getPath();
		List<String> list = new ArrayList<String>();
		BufferedReader input = null;
		try {
			input = new BufferedReader(new InputStreamReader(
					new FileInputStream(filePath), "UTF-8"));
			String line = null;
			while ((line = input.readLine()) != null) {
				list.add(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 读取resource目录下的文件
	 * @return 
	 */
	public static String readFile(String fileName) {
		String filePath = ResourceUtils.class.getClassLoader().getResource(fileName).getPath();
		try {
			filePath = URLDecoder.decode(filePath,"utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		StringBuffer sb = new StringBuffer();
		BufferedReader input = null;
		try {
			input = new BufferedReader(new InputStreamReader(
					new FileInputStream(filePath), "UTF-8"));
			String line = null;
			while ((line = input.readLine()) != null) {
				sb.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	public static String readFileForCode(String fileName) {
		String filePath = ResourceUtils.class.getClassLoader().getResource(fileName).getPath();
		StringBuffer sb = new StringBuffer();
		BufferedReader input = null;
		try {
			input = new BufferedReader(new InputStreamReader(
					new FileInputStream(filePath), "UTF-8"));
			String line = null;
			boolean b = false;
			while ((line = input.readLine()) != null) {
				if(!b){					
					sb.append(" \" "+line+"\"\n");
					b = true;
				}else{
					sb.append("+\" "+line+"\"\n");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

}
