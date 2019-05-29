package com.sangbill.basis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class TestRegExp {
	public static final String GPS_REGEXP = "^gps*";
	public static final String STATION_REGEXP = "^\\d+_(\\S)+.log$";
	public static void main(String[] args) {
//		Test1();
//		Test2();
//		   Test3();
//		Test4();
//		Test5();
//			Test6();
//		Test7();
//		System.out.println(toLegalLogName("2015003_device.log"));
//		System.out.println(toLegalLogName("gps-ddde.log"));
//		System.out.println("gps-".matches("^gps(\\S)+"));
//		TestData();
		String data =  "\n\r#### aaops load 1d \n\r![screenshot](http://xx/nodejs/tmp/chart.797157c5046e4b04aaa9b1f16b55a413.png)\n\r";
//		String data =  "\n\r#### aaops load 1d \n\r![screenshot](http:///chart.797157c5046e4b04aaa9b1f16b55a413.png)\n\r";

//		String data = "#在抖音，记录美好生活#这大概就是冰雪美人吧…… http://v.douyin.com/eUWYth/ 复制此链接，打开【抖音短视频】，直接观看视频！";
//        String regex = "(https?://(w{3}\\.)?)?\\w+\\.\\w+(\\.[a-zA-Z]+)*(:\\d{1,5})?(/\\w*)*(\\??(.+=.*)?(&.+=.*)?)?"; 
		String regex = "http://[0-9a-zZ-Z/]+chart.[0-9a-zA-Z]+.png";
        Pattern parrern = Pattern.compile(regex);
        Matcher matcher = parrern.matcher(data);
        if (matcher.find()){
            System.out.println(matcher.group());
        }
	}
	
	private static void TestData() {
		String str = "{ECG_HR}78|{ECG_PIC}|{ECG_RESULT}** 非典型心电图窦性心律 |{ECG_TYPEd}|68|67|29|140|80|364|414|120|0|  |$$||{ER| ";
		String[] strs = str.split("\\|");
		StringBuffer rs = new StringBuffer();
		String exp = "\\{[a-zA-Z_0-9]+\\}";
		for (int i = 0; i < strs.length; i++) {
			String s = strs[i];
			if(s.length() > 0){
				String temp = s.replaceAll(exp, "");
				if(temp.length() == s.length()){	//没找到花括号的格式，因此没替换到任何内容，则保留原数据
					rs.append(s+"|");
				}else{				//找到花括号的格式并发生了替换，如果内容纯由花括号的格式组成，则替换后为"",此时补0，否则用替换后的结果
					if(temp.length() == 0){
						rs.append("0|");
					}else{
						rs.append(temp+"|");
					}
				}
			}
		}
		if(rs.length() > 0){
			rs.deleteCharAt(rs.length()-1);
		}
		System.out.println(str+"\n"+rs);
	}

	public static boolean isEmpty(String data) {
		return (data == null || "".equals(data.trim()));
	}
	
	public static String formatMacAddress(String mac) {
		return mac.toUpperCase().replace("-", "").replace("_", "").replace(":", "").replace("\n", "").replace("\r", "");
	}
	/**
	 * 根据上传的文件名，转变成数据库中对应唯一的log名字
	 * 以后还有其他命名规则
	 * @param fileName
	 * @return
	 */
	public static String toLegalLogName(String fileName) {
		System.out.println("gps-dd".matches(GPS_REGEXP));
		String logName;
		if(fileName.matches(GPS_REGEXP)){
			logName = "gps";
		}else if(fileName.matches(STATION_REGEXP)){
			logName = matchStationLog(fileName);
		}else{
			logName = fileName;
		}
		return logName;
	}
	/**
	 * 装换到station数据库的log
	 * @param fileName
	 * @return
	 */
	private static String matchStationLog(String fileName) {
		Pattern p = Pattern.compile(STATION_REGEXP); 
		Matcher m = p.matcher(fileName);
		if (m.find()) {
			String s = m.group(0);
			s = s.replaceAll("\\d+_", "");
			return s;
		}else{
			return fileName;
		}
	}
	private static void Test7() {
		String logName = "2015_station_system.log";
		String regexp = "^\\d+_(\\S)+.log$";
		
		Pattern p = Pattern.compile(regexp); 
		Matcher m = p.matcher(logName);
		 if (m.find()) { 
			 String s = m.group(0);
			 s = s.replaceAll("\\d+_", "");
			 System.out.println(s);
           /* int count = m.groupCount();
            for (int i = 0; i <count; i++) {
				System.out.println("count:"+i+"->"+m.group(i));
			}*/
		 }
	}

	private static void Test6() {
		String str = "a2:34:5F:F2:2f";
		String p = "[a-f0-9A-F]{2}";
		if(str.matches("("+p+":)+"+p+"")){
			System.out.println(str);
		}
	
	}

	private static void Test5() {
		String str = "disk_io_read_bytes/sec@sd";
//		String str = "A-check_cpu_info";
//		String str = "Y-Y-tablespace_used_pct@%,tablespace_used_size@MB";
		Pattern p = Pattern.compile("^([a-z0-9/_]+)@$"); 
		Matcher m = p.matcher(str);
		 if (m.find()) { 
            int count = m.groupCount();
            for (int i = 0; i <count; i++) {
				System.out.println("count:"+i+"->"+m.group(i));
			}
		 }
		
	}

	private static void Test4() {
		String str = "Y-Y-disk_io_read_bytes/sec,disk_io_write_bytes/sec";
//		String str = "A-check_cpu_info";
//		String str = "Y-Y-tablespace_used_pct@%,tablespace_used_size@MB";
		Pattern p = Pattern.compile("^[Y|N|-|A]-([a-z0-9/]+)(,[a-z0-9/]+)+$"); 
		Matcher m = p.matcher(str);
		 if (m.find()) { 
            int count = m.groupCount();
            for (int i = 0; i <count; i++) {
				System.out.println("count:"+i+"->"+m.group(i));
			}
		 }
	}

	private static void Test3() {
		String str = "WWW-MIB-dd99.txt";
		Pattern p = Pattern.compile("^*(-[a-z]+[0-9]+)?.txt$"); 
		Matcher m = p.matcher(str);
		 if (m.find()) { 
            int count = m.groupCount();
            for (int i = 0; i <count; i++) {
				System.out.println("count:"+i+"->"+m.group(i));
			}
         } 
	}

	private static void Test2() {
		Pattern p = Pattern.compile("^The parent of ([a-zA-Z]+) is not found!$"); 
		Matcher m = p.matcher("The parent of ActiveConnectionsCurrentCount is not found!"); 
		 if (m.find()) { 
             String s0 = m.group(); 
             String s1 = m.group(1); 
             System.out.println(s0 + "||" + s1); 
         } 
	}

	private static void Test1() {
		/*Pattern p = Pattern.compile("f(.+?)k"); 
        Matcher m = p.matcher("fckfkkfkf"); 
        while (m.find()) { 
                String s0 = m.group(); 
                String s1 = m.group(1); 
                System.out.println(s0 + "||" + s1); 
        } 
        System.out.println("---------"); 
        m.reset("fucking!"); 
        while (m.find()) { 
                System.out.println(m.group()); 
        } 

        Pattern p1 = Pattern.compile("f(.+?)i(.+?)h"); 
        Matcher m1 = p1.matcher("finishabigfishfrish"); 
        while (m1.find()) { 
                String s0 = m1.group(); 
                String s1 = m1.group(1); 
                String s2 = m1.group(2); 
                System.out.println(s0 + "||" + s1 + "||" + s2); 
        } 

        System.out.println("---------"); 
        Pattern p3 = Pattern.compile("(19|20)\\d\\d([- /.])(0[1-9]|1[012])\\2(0[1-9]|[12][0-9]|3[01])"); 
        Matcher m3 = p3.matcher("1900-01-01 2007/08/13 1900.01.01 1900 01 01 1900-01.01 1900 13 01 1900 02 31"); 
        while (m3.find()) { 
                System.out.println(m3.group()); 
                System.out.println(m3.group(0)+"#"+m3.group(1)+"#"+m3.group(2)+"#"+m3.group(3));
        } */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-mm-dd HH:MM:ss");
		String regex = "(\\d{4})([-/.]\\d{1,2})([-/.]\\d{1,2})?";
        Pattern p = Pattern.compile(regex); 
        String[] s = {"1908.01","1900.6","1998-12-3","201.12","2012","2333-04-3"};
        for (int i = 0; i < s.length; i++) {
        	Matcher m = p.matcher(s[i]);
        	if(m.find()){
        		String yyyy = m.group(1);
        		String mm = m.group(2).substring(1);
        		String dd = (m.group(3) == null)?"01":m.group(3).substring(1);
        		String dateStr = yyyy+"-"+mm+"-"+dd;
        		try {
        			Date d = sdf.parse(dateStr);
					System.out.println(dateStr+"-->"+sdf1.format(d));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}else{
        		System.out.println(s[i]+" not find");
        	}      	
		}
	}
}

