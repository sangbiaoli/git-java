package com.sangbill.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.sangbill.entity.ExcelNode;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelUtil {
	/**
	 * 导入excel文件，分步骤：
	 * 1.获取文件，并获得第一个工作表
	 * 2.检查工作表表头是否有效：
	 * 		a.所有预定义的列必须在excel表中体现，否则提示缺少列
	 * 		b.获取预定义的列在excel中的顺序
	 * @param filePath
	 * @param head
	 * @param headRowIndex
	 * @param clazz
	 * @return
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 */
	@SuppressWarnings("rawtypes")
	public static List importFromExcel(String filePath, String[][] head, int headRowIndex,
			Class<?> clazz){
		List list = null;
		InputStream input = null;
		try {
			HashMap<String,ExcelNode> preColumn = initPreHead(head,clazz);
			input = new FileInputStream(filePath);
			if(input.available() > 0 ){
				Workbook wb = null;
				try {
					wb = Workbook.getWorkbook(input);
				} catch (BiffException e) {
					e.printStackTrace();
				}// 根据输入流创建工作薄(从工作表中读取数据)
	    		input.close();	
	    		Sheet rs = wb.getSheet(0);//获得第一个工作表
	    		HashMap<Integer, ExcelNode> colunm = checkHead(rs,headRowIndex,preColumn);
	    		if(preColumn.size() >0){
	    			String msg = getMsg(preColumn);
	    			System.out.println(msg);
	    		}
	    		list = convertToList(rs,headRowIndex,colunm,clazz);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 将excel数据转换成List
	 * @param rs
	 * @param headRowIndex
	 * @param colunm
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static List convertToList(Sheet rs, int headRowIndex,
			HashMap<Integer, ExcelNode> colunm, Class<?> clazz) throws Exception {		
		List list = new ArrayList();
		for (int i = headRowIndex+1; i < rs.getRows(); i++) {
			Cell[] cell = rs.getRow(i);
			Object object = clazz.newInstance();
			for (Iterator it = colunm.keySet().iterator(); it.hasNext();) {
				Integer colIndex = (Integer) it.next();
				String content = cell[colIndex].getContents();
				ExcelNode node = colunm.get(colIndex);
				RefUtils.invokeSetterMethod(object,node.getField(),content);
			}
			list.add(object);
		}
		return list;
	}
	
	@SuppressWarnings("rawtypes")
	private static String getMsg(HashMap<String, ExcelNode> preColumn) {
		StringBuffer sb = new StringBuffer();
		sb.append("列(");
		for (Iterator it = preColumn.keySet().iterator(); it.hasNext();) {
			String s = (String) it.next();
			sb.append(preColumn.get(s).getEnName()+",");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append(")不存在");
		return sb.toString();
	}
	/**
	 * 初始化表头
	 * @param head
	 * @param clazz
	 * @return
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 */
	private static HashMap<String,ExcelNode> initPreHead(String[][] head, Class<?> clazz) throws NoSuchFieldException, SecurityException {
		HashMap<String,ExcelNode> preColumn = new HashMap<String,ExcelNode>();
		for (int j = 0; j < head[0].length; j++) {
			ExcelNode node = new ExcelNode();
			node.setChName(head[0][j]);
			node.setEnName(head[1][j]);
			Field field = clazz.getDeclaredField(node.getEnName());
			node.setField(field);
			preColumn.put(node.getChName(), node);
		}
		return preColumn;
	}
	private static HashMap<Integer,ExcelNode> checkHead(Sheet rs, int headRowIndex,
			HashMap<String, ExcelNode> columnMap) {
		HashMap<Integer,ExcelNode> column = new HashMap<Integer,ExcelNode>();
		for (int i = 0; i < rs.getColumns(); i++) {
			String excelHead = rs.getCell(i,headRowIndex).getContents();
			if(!StringUtils.isEmpty(excelHead)){
				if(columnMap.containsKey(excelHead)){
					column.put(i,columnMap.get(excelHead));
					columnMap.remove(excelHead);
				}
			}
		}
		return column;
	}
	/**
	 * @param string
	 * @param head
	 * @param i
	 * @param list
	 * @param clazz
	 * @throws Exception 
	 */
	public static void exportExcel(String filePath, String[][] head, int headRowIndex, List list, Class<?> clazz){
		try {
			// 第一步，创建一个webbook，对应一个Excel文件
			HSSFWorkbook wb = new HSSFWorkbook();
			// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
			HSSFSheet sheet = wb.createSheet("sheet");
			// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
			HSSFCellStyle style = wb.createCellStyle();
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
			createHead(sheet, style, head, headRowIndex);
			// 第四步，写入实体数据
			for (int i = 0; i < list.size(); i++) {
				HSSFRow row = sheet.createRow(headRowIndex + 1 + i);// 从第i行开始写入数据
				Object obj = list.get(i);
				for (int j = 0; j < head[1].length; j++) {	//英文名
					Object value = RefUtils.invokeGetterMethod(obj, head[1][j]);
					HSSFCell cell = row.createCell(j);
					if (value instanceof Date) {
						Date d = (Date) value;
						cell.setCellValue(DateUtil.convertDateToStr(d, "yyyy-MM-dd"));
					} else if (value instanceof Double) {
						cell.setCellValue((Double) value);
					} else if (value instanceof Boolean) {
						cell.setCellValue((Boolean) value);
					} else {
						cell.setCellValue(value.toString());
					}
				}
			}
			// 第五步，将文件存到指定位置
			FileOutputStream fout = new FileOutputStream(filePath);
			wb.write(fout);
			fout.close();
			System.out.println("export excel done!");
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	/**
	 * 导出时创建表头
	 * @param sheet
	 * @param style 
	 * @param head
	 * @param headRowIndex 
	 */
	private static void createHead(HSSFSheet sheet, HSSFCellStyle style, String[][] head, int headRowIndex) {
		HSSFRow row = sheet.createRow(headRowIndex);
		for (int i = 0; i < head.length; i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellValue(head[0][i]);	//设置中文为表头
			cell.setCellStyle(style);
		}
        
	}
}
