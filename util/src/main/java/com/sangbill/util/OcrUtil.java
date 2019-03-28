package com.sangbill.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.util.ImageHelper;

public class OcrUtil {
	public static void main(String[] args) {
		String filePath = "C:\\Users\\bill\\Desktop\\aa.png";
		String rs = ocr(filePath );
		System.out.println(rs);
	}

	private static String ocr(String filePath) {
	    String result = null;
	    try {
	        BufferedImage image = ImageIO.read(new File(filePath));
	        // 这里对图片黑白处理,增强识别率.这里先通过截图,截取图片中需要识别的部分
	        BufferedImage textImage = ImageHelper.convertImageToGrayscale(ImageHelper.getSubImage(image, 412, 340, 133, 32));
	        // 图片锐化
	        textImage = ImageHelper.convertImageToBinary(textImage);
	        // 图片放大倍数,增强识别率(很多图片本身无法识别,放大5倍时就可以轻易识,但是考滤到客户电脑配置低,针式打印机打印不连贯的问题,这里就放大5倍)
	        textImage = ImageHelper.getScaledInstance(textImage, textImage.getWidth() * 2, textImage.getHeight() * 2);
	
	        textImage = ImageHelper.convertImageToBinary(textImage);
	        //ImageIO.write(textImage, "png", new File("C:\\Users\\JiangJie\\Pictures\\timg_temp.jpg"));
	
	        Tesseract instance = new Tesseract();
	        instance.setDatapath("C:\\Program Files (x86)\\Tesseract-OCR\\tessdata");//设置训练库的位置
	        instance.setLanguage("chi_sim");//中文识别
	        //instance.setLanguage("eng");//英文识别
	        result = instance.doOCR(textImage);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return result;
	}
	
	private static String filter(String str) {
	    String regEx = "[`~!@#$%^&*()+=|{}':;,\"\\[\\].<>/?￥……&*（）__′_—+|{}【】'；：”“’。，、？]";
	    Pattern p = Pattern.compile(regEx);
	    Matcher m = p.matcher(str);
	    return m.replaceAll("").trim();
	}
	
	
}

