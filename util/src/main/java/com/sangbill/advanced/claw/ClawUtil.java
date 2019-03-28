package com.sangbill.advanced.claw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sangbill.util.FileUtil;

public class ClawUtil {
	public static void main(String[] args) {
//		loadPage("http://www.manhuntdiario.com/wp-content/uploads/", "manhuntdiario.txt");
//		loadPage("http://www.filmmakeriq.com/wp-content/uploads/", "filmmakeriq.txt");
//		loadPage("http://mhdiario-1586104088.us-east-1.elb.amazonaws.com/wp-content/uploads/", "mhdiario.txt");
//		loadPage("http://radarx.com.br/blog/wp-content/uploads/", "radarx.txt");
//		loadPage("http://www.fernandomachado.blog.br/novo/wp-content/uploads/", "fernandomachado.txt");
//		loadPage("http://www.filmmakeriq.com/wp-content/uploads/", "filmmakeriq.txt");
//		loadPage("http://ilike.mk/wp-content/uploads/images/", "ilike.txt");
		loadPage("http://www.thescienceofappearance.com/wp-content/uploads/", "thescienceofappearance.txt");

//		loadPageByAlpha("http://manhuntdiario.com/wp-content/uploads/wp-content/blogs.dir/alpha/", "manhuntdiario_alpha.txt");
//		filter("manhuntdiario.txt", "manhuntdiario_temp.txt");
	}

	
	/**
	 * 过滤小图
	 * @author liqiangbiao
	 * 2017年5月5日
	 *  @param fileName
	 *  @param fileName2
	 * void
	 */
	private static void filter(String fileName, String fileName2) {
		System.out.println(fileName);
		StringBuffer sb = new StringBuffer();
		BufferedReader input = null;
		try {
			input = new BufferedReader(new InputStreamReader(
					new FileInputStream(fileName), "UTF-8"));
			String line = null;
			String spaceReg = "(\\S)+[\\d]{2,4}x[\\d]{0,4}.+$";

			while ((line = input.readLine()) != null) {
				if(!line.trim().matches(spaceReg)){
					sb.append(line+"\n");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		FileUtil.writeFile(fileName2, sb.toString());
		System.out.println("done");
	}


	
	/**
	 * 按字母抓取
	 * @author liqiangbiao
	 * 2017年5月5日
	 *  @param baseUrl
	 *  @param fileName
	 * void
	 */
	private static void loadPageByAlpha(String baseUrl, String fileName) {
		StringBuffer sb = new StringBuffer();
		String chars = "abcdefghijklmnopqrstuvwxyz";
		for (int i = 0; i < chars.length(); i++) {
			char c = chars.charAt(i);
			sb.append(c + "\n");
			System.out.println(c);
			List<String> pics = getPic(baseUrl + c + "/");
			for (int k = 0; k < pics.size(); k++) {
				sb.append("\t\t" + pics.get(k) + "(" + c + ")" + "\n");
			}
		}
		FileUtil.writeFile(fileName, sb.toString());
		System.out.println("done");
		
	}
	/**
	 * 按年月抓取
	 * @author liqiangbiao
	 * 2017年5月5日
	 *  @param baseUrl
	 *  @param fileName
	 * void
	 */
	private static void loadPage(String baseUrl, String fileName) {
		StringBuffer sb = new StringBuffer();
		List<String> years = getYear(baseUrl);
		if (years.size() > 0) {
			for (int i = 0; i < years.size(); i++) {
				String year = years.get(i);
				sb.append(year + "\n");
				List<String> months = getMonth(baseUrl + year);
				System.out.println(year);
				if (months.size() > 0) {
					for (int j = 0; j < months.size(); j++) {
						String month = months.get(j);
						String yearAndMonth = year.substring(0,4) + "/" + month.substring(0, 2);
						sb.append("\t" + month + "\n");
						System.out.println("\t" + months.get(j));
						List<String> pics = getPic(baseUrl + year + "/" + month);
						for (int k = 0; k < pics.size(); k++) {
							sb.append("\t\t" + pics.get(k) + "(" + yearAndMonth + ")" + "\n");
						}
					}
				}
			}
		}
		FileUtil.writeFile(fileName, sb.toString());
		System.out.println("done");
	}

	private static List<String> getPic(String url) {
		List<String> list = new ArrayList<String>();
		Document doc;
		try {
			Connection connection = Jsoup.connect(url).timeout(50000);
			connection.userAgent("Chrome/10.0.648.133");
			doc = connection.get();
			Elements links = doc.getElementsByTag("a");
			for (Element link : links) {
				String href =  link.attr("href");
				if (test(href)) {
					list.add(href);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	private static boolean test(String href) {
		boolean b = true;
		String headReg = "(Parent Directory|Name|Last modified|Size|Description)";
		String spaceReg = "(\\S)+[\\d]{2,4}x[\\d]{0,4}.+$";
		String thumReg = "(\\S)+thum?+.+$";
		String imgReg = ".+(.JPEG|.jpeg|.JPG|.jpg|.GIF|.gif|.BMP|.bmp|.PNG|.png)$";
		if (href.matches(headReg) || href.matches(spaceReg) || href.matches(thumReg) || !href.matches(imgReg)) {
			b = false;
		}
		return b;
	}
	
	private static List<String> getYear(String url) {
		List<String> list = new ArrayList<String>();
		Document doc;
		try {
			Connection connection = Jsoup.connect(url);
			connection.userAgent("Chrome/10.0.648.133");
			doc = connection.get();
			Elements links = doc.getElementsByTag("a");
			for (Element link : links) {
				String linkText = link.text();
				if (linkText.matches("[\\d]{4}/")) {
					list.add(linkText);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	private static List<String> getMonth(String url) {
		List<String> list = new ArrayList<String>();
		Document doc;
		try {
			Connection connection = Jsoup.connect(url);
			connection.userAgent("Chrome/10.0.648.133");
			doc = connection.get();
			Elements links = doc.getElementsByTag("a");
			for (Element link : links) {
				String linkText = link.text();
				if (linkText.matches("[\\d]{2}/")) {
					list.add(linkText);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
