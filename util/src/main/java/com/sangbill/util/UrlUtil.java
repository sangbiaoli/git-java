package com.sangbill.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class UrlUtil {
	/**
	 * 根据文件和url，下载文件
	 * @author liqiangbiao
	 * @param f
	 * @param url
	 */
	public static void download(File f, String url) {
		byte[] buffer = new byte[8 * 1024];
		URL u;
		URLConnection connection = null;
		try {
			u = new URL(url);
			connection = u.openConnection();
		} catch (Exception e) {
			System.out.println("ERR:" + url);
			return;
		}
		connection.setReadTimeout(100000);
		InputStream is = null;
		FileOutputStream fos = null;
		try {
			f.createNewFile();
			is = connection.getInputStream();
			fos = new FileOutputStream(f);
			int len = 0;
			while ((len = is.read(buffer)) != -1) {
				fos.write(buffer, 0, len);
			}
			System.out.println("download file done!");
		} catch (Exception e) {
			f.delete();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
				}
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
				}
			}
		}
		buffer = null;
	}
}
