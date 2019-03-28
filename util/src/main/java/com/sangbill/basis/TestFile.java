package com.sangbill.basis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.sangbill.advanced.order.Message;
import com.sangbill.advanced.order.SortByMethod;
import com.sangbill.util.FileUtil;

public class TestFile {

	public static void main(String[] args) {

		/*
		 * String numFilePath = "number.txt"; String stringFilePath = "log.txt";
		 * String fxg = "flex.fxg"; //testInputFile(numFilePath);
		 * //testOutputFile(stringFilePath); write(fxg);
		 */
		// testPath();
		// parseNagiosLog();
		// saveFile("1.txt", "add");
//		testZip();
//		testTar();
//		test();
		test1();
	}

	private static void test1() {
//		FileHelper.unTargz("log.tar.gz", null);
		FileUtil.unTargz("device.tar.gz", "device");
	}

	private static void test() {
		FileUtil.unzip("a.zip", null);
		
	}

	private static void testTar() {
		/*try {
			FileUtil.unTargzFile("a.rar", "c");
		} catch (UnTarzException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}

	private static void testZip() {
		/*try {
			FileUtil.unZipToFolder("a.zip", "d");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
//		FileUtil.unZip("a.zip");
//		System.out.println("压缩完毕");
	}

	public static boolean saveFile(String path, String content) {
		boolean isSuccess = true;
		FileOutputStream fop = null;
		File file;
		try {
			file = new File(path);
			fop = new FileOutputStream(file);
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			// get the content in bytes
			byte[] contentInBytes = content.getBytes();
			fop.write(contentInBytes);
			fop.flush();
			fop.close();
		} catch (IOException e) {
			e.printStackTrace();
			isSuccess = false;
		} finally {
			try {
				if (fop != null) {
					fop.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return isSuccess;
	}

	private static void parseNagiosLog() {
		List<Message> list = new ArrayList<Message>();
		BufferedReader input = null;
		String path = "nagitm.log";
		try {
			input = new BufferedReader(new InputStreamReader(
					new FileInputStream(path), "UTF-8"));
			String line = null;
			try {
				while ((line = input.readLine()) != null) {
					if (line.indexOf("NotifyManager") > -1) {
						String time;
						String content;
						String res;
						Integer index = line.indexOf("http");
						if (index == -1) {
							index = line.indexOf("Alarm_Handle_Thread");
						}
						time = line.substring(0, index - 1);
						index = line.indexOf("发送短信");
						content = line.substring(index + 5);
						index = content.indexOf("上");
						if (index == -1) {
							index = content.indexOf("在");
						}
						res = content.substring(0, index);
						Message msg = new Message();
						msg.setTime(time);
						msg.setRes(res);
						msg.setMsg(content);
						list.add(msg);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (input != null)
				try {
					input.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		SortByMethod<Message> sort = new SortByMethod<Message>();
		sort.sortByMethod(list, "getRes", false);
		sort.sortByMethod(list, "getTime", false);
		print(list);
	}

	private static void print(List<Message> list) {
		for (int i = 0; i < list.size(); i++) {
			Message msg = list.get(i);
			System.out.println(msg.getTime() + "\t" + msg.getRes() + "\t"
					+ msg.getMsg());
		}
		System.out.println("\n\n");
	}

	private static void testPath() {
		System.out.println(System.getProperty("user.dir") + "\\src\\"
				+ "verialbe.json");

	}

	private static void write(String fxg) {
		int number;
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(fxg);
			String format = testOutputFile("test.fxg");
			int x1 = 5;
			int y1 = 4;
			int x2 = 600;
			int y2 = 700;
			int increament = 95;
			for (int i = y1; i < y2; i = i + increament) {
				for (int j = x1; j < x2; j = j + increament) {
					String str = String.format(format, i, j);
					// System.out.println(str);
					writer.print(str + "\n");
				}
			}
			// System.out.println(formate.replaceAll("x0",
			// x1+"").replaceAll("y0", y1+""));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			writer.close();
		}

	}

	// open a file and find out the "error" string
	private static String testOutputFile(String filePath) {
		BufferedReader input = null;
		final String destString = "ERROR";
		try {
			input = new BufferedReader(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String line;
		StringBuffer sb = new StringBuffer();
		try {
			while ((line = input.readLine()) != null) {
				sb.append(line + "\n");
			}
			return sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";

	}

	// create a file and input some Integer
	private static void testInputFile(String filePath) {
		int number;
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(filePath);
			for (int i = 0; i < 50; i++) {
				number = (int) (Math.random() * 1000);
				writer.print(number + "\n");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			writer.close();
		}
	}

}