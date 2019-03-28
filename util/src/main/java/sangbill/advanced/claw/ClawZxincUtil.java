package com.sangbill.advanced.claw;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.sangbill.util.FileUtil;

public class ClawZxincUtil {
	public static String BASE_URL = "http://www.zxinc.org/gb2260-latest.htm?tdsourcetag=s_pcqq_aiomsg";
	public static  Pattern LEVEL_0 = Pattern.compile("^([\\d]{6})　([\\u4e00-\\u9fa5]+)$");
	public static  Pattern LEVEL_1 = Pattern.compile("^([\\d]{6})　　([\\u4e00-\\u9fa5]+)$");
	public static  Pattern LEVEL_2 = Pattern.compile("^([\\d]{6})　　　([\\u4e00-\\u9fa5]+)$");

	
	public static void main(String[] args) {
		List<SysArea> list = new ArrayList<SysArea>();
		getData(list);
		
		/*StringBuffer sb = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i).toString() + "\n");
		}
		FileUtil.writeFile("sysarea.txt", sb.toString());*/
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO SYS_AREA_CODE_NEW (AREA_NAME, AREA_LEVEL, DISTRICT_CODE) VALUES ");
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i).getSql()+"\n");
		}
		FileUtil.writeFile("sysarea.sql", sb.toString());
	}
	
	private static SysArea parseArea(String str){
		int base = 6;
		if(str.length() >= base){			
			int level = -1;
			String name = "";
			String areaCode = str.substring(0,base);
			if(str.matches(LEVEL_0.pattern())){
				level = 0;
				name = str.substring(base+1,str.length());
			}else if(str.matches(LEVEL_1.pattern())){
				level = 1;
				name = str.substring(base+2,str.length());
			}else if(str.matches(LEVEL_2.pattern())){
				level = 2;
				name = str.substring(base+3,str.length());
			}
			SysArea area = new SysArea(name, areaCode, level);
			return area;
		}else{
			return null;
		}
	}
	
	private static void getData(List<SysArea> list) {
		Document doc;
		try {
			Connection connection = Jsoup.connect(BASE_URL);
			connection.userAgent("Chrome/10.0.648.133");
			doc = connection.get();
			Elements areacode = doc.getElementsByTag("areacode");
			String[] datas = areacode.outerHtml().split("<br>");
			for (int i = 0; i < datas.length; i++) {
				String text = datas[i];
				if(text.indexOf("areacode") == -1 && text.indexOf("中华人民共和国 ") == -1){
					text = text.replace("\n", "").trim();
					SysArea area = parseArea(text);
					list.add(area);
				}
			}
			System.out.println(datas);
		} catch (IOException e) {
			// e.printStackTrace();
		}
	}
}
