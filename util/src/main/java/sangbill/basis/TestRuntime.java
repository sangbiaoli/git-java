package com.sangbill.basis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

/**
 * Main.java
 *
 * @author outofmemory.cn
 */
public class TestRuntime {

    /**
     * Displays the number of processors available in the Java Virtual Machine
     */
    public void displayAvailableProcessors() {

        Runtime runtime = Runtime.getRuntime();

        int nrOfProcessors = runtime.availableProcessors();

        System.out.println("Number of processors available to the Java Virtual Machine: " + nrOfProcessors);

    }

    /**
     * Starts the program
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        new TestRuntime().displayAvailableProcessors(); 
    	test("192.168.58.94");
    	test("192.168.58.48");
    	test("192.168.58.24");
    }

	private static void test(String ip) {
		Date d1 = new Date();
    	testPing(ip);
    	Date d2 = new Date();
    	System.out.println("ping执行时间："+(d2.getTime()-d1.getTime())/100+"s");	
	}

	private static String testPing(String ip) {
		
		String line = null;
		String cmd = "ping " + ip + " -n 4 -w 30000";// -n 发送4个包，-w
														// 超时时间(毫秒)，每个包的超时时间
		BufferedReader buf = null;
		Process pro = null;
		try {
			pro = Runtime.getRuntime().exec(cmd);
			buf = new BufferedReader(new InputStreamReader(
					pro.getInputStream(), "GBK"));
			Collection<String> list = Arrays.asList("无法访问目标主机", "请求超时",
					"请求找不到主机", "TTL 传输中过期");
			// 遇到文字流有"请求超时"或"数据包"，都跳出循环
			while ((line = buf.readLine()) != null) {
				// 循环那种特殊ping结果
				for (String s : list) {
					if (line.contains(s)) {
						if ("请求超时".equals(s)) {// 请求超时可能是“请求超时”或“主机不可达”
							return "请求超时或主机不可达";
						} else {
							return s;
						}
					}
				}
				if (line.contains("数据包")) { // 例如："数据包: 已发送 = 4，已接收 = 4，丢失 = 0 (0% 丢失)，"这说明已经ping完毕
					break;
				}
			}
			return line;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (pro != null) {
				pro.destroy();
			}
			if (buf != null) {
				try {
					buf.close();
				} catch (IOException e) {
					System.out.println("关闭流出错：" + e.getMessage());
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}