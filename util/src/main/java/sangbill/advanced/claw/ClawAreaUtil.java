package com.sangbill.advanced.claw;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.sangbill.util.FileUtil;

public class ClawAreaUtil {
	public static String BASE_URL = "https://xingzhengquhua.51240.com/";
	public static String SUB_PATH = "__xingzhengquhua/";
	public static String TD = "<td bgcolor=\"#F5F5F5\">所辖行政区</td>";
	public static String NO_DATA = "<td colspan=\"3\" bgcolor=\"#FFFFFF\" align=\"center\">无所辖行政区</td>";

	public static void main(String[] args) {
		List<SysArea> list = new ArrayList<SysArea>();
		getTable(list, 0, "");

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i).toString() + "\n");
		}
		FileUtil.writeFile("sysarea.txt", sb.toString());
	}

	private static void getTable(List<SysArea> list, int level, String path) {
		Document doc;
		try {
			Thread.sleep(500);
			Connection connection = Jsoup.connect(BASE_URL + path);
			connection.userAgent("Chrome/10.0.648.133");
			doc = connection.get();
			Elements table = doc.getElementsByTag("table");
			Elements areaTable = table.select("table").select("tr").select("td");

			if (areaTable.outerHtml().indexOf(TD) > -1 && areaTable.outerHtml().indexOf(NO_DATA) == -1) {
				Elements trs = areaTable.select("table").select("tr");
				int start = -1;
				for (int i = 0; i < trs.size(); i++) {
					if (trs.get(i).outerHtml().indexOf(TD) > -1) {
						start = i + 1;
						break;
					}
				}
				if (start > -1) {
					for (int i = start; i < trs.size(); i++) {
						Elements tds = trs.get(i).select("td");
						String name = tds.get(0).text();
						String areaCode = tds.get(1).text();
						SysArea area = new SysArea(name, areaCode, level);
						list.add(area);
						System.out.println(area.toString());
						getTable(list, level + 1, areaCode + SUB_PATH);
					}
				}
			}
		} catch (IOException e) {
			// e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
