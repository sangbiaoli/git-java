package com.sangbill.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import com.sangbill.entity.Book;
import com.sangbill.entity.Books;
import com.sangbill.entity.ExcelModel;
import com.sangbill.util.ExcelUtil;
import com.sangbill.util.JepUtil;
import com.sangbill.util.MessyCodeUtil;
import com.sangbill.util.MixedUtil;
import com.sangbill.util.ResourceUtils;
import com.sangbill.util.XStreamUtil;

import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

public class Test {
	
	public static void main(String[] args) throws Exception {
//		testJepUtil();
//		testMessyCode();
//		testExcel();
//		testMixed();
//		testResource();
//		testXStream();
//		testFile();
//		testList();
//		testOngl();
//		testCal();
//		testIp();
		/*String s = "Asd1231fs18012131s.DCE";
		Pattern p = Pattern.compile("(\\d+)");
		Matcher m = p.matcher(s);
	    while (m.find()) {
	    	System.out.println(m.group(0));
        }*/
		
		
//		testRemove();
		/*int instanceId = 1254160;
		int taskId = 236;
		long time = System.currentTimeMillis();
		String key = taskId + "_" + instanceId + "_" + time; 
		String s = DigestUtils.md5Hex(key);
		System.out.println(time+"\t"+s);*/
		 
		/*ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < 51; i++) {
			list.add(i);
		}
		PageSupport page = new PageSupport(list,null,  list.size(), 10, 1);
		for (int i = 0; i <= page.getPageCount(); i++) {			
			System.out.println(i+"-->"+page.getPage(i));
		}
		
		PageSupport page2 = new PageSupport(null,list.subList(0, 10),  list.size(), 10, 1);
		System.out.println(page2);*/
		Vector v = new Vector(10);

		for (int i = 0; i < 100; i++) {
		    Object o = new Object();
		    v.add(o);
		    o = null;
		}
		System.out.println(v.size());
	}



	private static void testRemove() {
		Book book = new Book();
		book.setAuthor("bill");
		book.setName("java");
		List<Book> list = new ArrayList<Book>();
		list.add(book);
		List<Book> removeList = new ArrayList<Book>();
		for (Book vo : list) {
			if(vo.getAuthor().equals("bill")){
				removeList.add(vo);
			}
		}
		for (Book vo : list) {
			if(vo.getName().equals("java")){
				removeList.add(vo);
			}
		}
		System.out.println(removeList.size());//同一个地址，存了两份
		list.removeAll(removeList);
		System.out.println(list.size());

	}

	private static void testCal() {
		Calendar cal = Calendar.getInstance();
		int index = cal.get(Calendar.MINUTE);
		index = index % 30;
		System.out.println(index);
		
	}

	private static void testOngl() {
		HashMap map = new HashMap();
		
		OgnlContext context = new OgnlContext();
		Object obj1;
		try {
			obj1 = Ognl.parseExpression("country"); 	//解析ognl表达式
			Ognl.getValue(obj1, context, context.getRoot()); //获取ognl的表达式值,obj1是上面一个api，其他两个分别是创建的上下文对象以及一个不用修改的参数
			Object obj2 = Ognl.parseExpression("language.toUpperCase()"); //方法调用
			Object obj3 = Ognl.parseExpression("@java.lang.Integer@toBinaryString(10)");//等同于上面
			Object obj4 = Ognl.parseExpression("@@min(10,4)"); //Math类的方法直接调用,静态方法的调用
		} catch (OgnlException e) {
			e.printStackTrace();
		}
	}

	private static void testList() {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for (int i = 0; i < 10; i = i+2) {
			map.put(i, i);
		}
		List<Integer> rs = new ArrayList<Integer>();
		for (Integer temp : list) {
			if(map.containsKey(temp)){
				rs.add(temp);
			}
		}
		list.removeAll(rs);
		System.out.println(list);
	}

	private static void testFile() {
		System.out.println(ResourceUtils.readFileForCode("sta_order.sql"));
		
	}

	private static void testXStream() {
		String xmlString = ResourceUtils.readFile("books.xml");
        Books books = XStreamUtil.toBean(xmlString, Books.class);
        System.out.println(XStreamUtil.toXml(books));
	}

	private static void testResource() {
		ResourceUtils.readFolder();
		ResourceUtils.readFile("logs/compute.log");
	}

	/**
     * 向指定URL发送GET方法的请求
     * 
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }
	

	private static void testMixed() {
		for(int i = 10100000; i<10211000;i++){
			if(!MixedUtil.testContinus(i)){				
				System.out.println(i+":false");
			}
		}	
	}
	
	@SuppressWarnings("rawtypes")
	private static void testExcel() {
		String head[][] = { 
				{ "字符串", "整型", "日期", "日期时间" },
				{ "estr", "eint", "edate", "edateTime" } 
			};
		List list = ExcelUtil.importFromExcel("export.xls", head, 0, ExcelModel.class);		
		System.out.println(list.size());
		ExcelUtil.exportExcel("export_bak.xls",head,0,list,ExcelModel.class);
	}

	private static void testMessyCode() {
		System.out.println(MessyCodeUtil.isMessyCode("*��JTP.jar�ļ����JTP�ļ���ȡ��ͼƬ��Դ"));
		System.out.println(MessyCodeUtil.isMessyCode("你好"));
	}
	
	private static void testJepUtil() {
		String temp = "70<=72.0 && 72.0<80";
		System.out.println(JepUtil.getExpressValue(temp));
	}
}
