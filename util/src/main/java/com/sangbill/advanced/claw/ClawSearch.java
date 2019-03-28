package com.sangbill.advanced.claw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import com.sangbill.util.PropertiesUtil;

public class ClawSearch {
	public static void main(String[] args) {
		search("Harington");
//		Jesse Metcalfe
	}
	
	private static void search(String key) {
		File directory = new File("");//设定为当前文件夹
		File[] list = new File(directory.getAbsolutePath()).listFiles();
		for (int i = 0; i < list.length; i++) {
			String fileName = list[i].getName();
			if(list[i].isFile() && fileName.endsWith(".txt") && !fileName.equals("manhuntdiario_alpha.txt")){
				search(fileName,key);
				System.out.println("\n");
			}
		}
	}

	/**
	 * 根据key,文件查询
	 * @author liqiangbiao
	 * 2017年5月5日
	 *  @param fileName
	 *  @param key
	 * void
	 */
	private static void search(String fileName, String key) {
		Properties p = PropertiesUtil.getProperties("claw.properties");
		System.out.println(fileName);
		String url = p.getProperty(fileName.substring(0,fileName.indexOf(".txt")));
		System.out.println(url);
		StringBuffer sb = new StringBuffer();
		BufferedReader input = null;
		try {
			input = new BufferedReader(new InputStreamReader(
					new FileInputStream(fileName), "UTF-8"));
			String line = null;
			int i = 1;
			while ((line = input.readLine()) != null) {
				if(line.toLowerCase().indexOf(key.trim().toLowerCase()) > 0){					
					sb.append(parse(line)+"\n");
				}
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(sb.toString());
	}

	private static String parse(String line) {
		int index = line.indexOf("(");
		return line.substring(index+1,index+8)+"/"+line.substring(0,index).trim();
	}
}
