package com.sangbill.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.log4j.Logger;

public class FileUtil {
	private static final String ZIP = ".zip";
	private static Logger logger = Logger.getLogger(FileUtil.class);
	/**
	 * 解压zip文件到制定目录，如果制定目录为Null，则以文件名为目录名称
	 * 
	 * @param fileName
	 * @param dir
	 */
	public static void unzip(String fileName, String dir) {
		String fileDir = null;
		ZipInputStream in = null;
		ZipEntry entry = null;
		File Fout = null;
		BufferedInputStream bis = null;
		// 获取压缩文件目录
		if (dir == null) {
			fileDir = removeSuffix(fileName, ZIP);
		} else {
			fileDir = dir;
		}
		// 读取并解压文件
		try {
			in = new ZipInputStream(new BufferedInputStream(new FileInputStream(fileName)));
			bis = new BufferedInputStream(in);  
			while ((entry = in.getNextEntry()) != null && !entry.isDirectory()) {
				Fout = new File(fileDir, entry.getName());
				if (!Fout.exists()) {
					(new File(Fout.getParent())).mkdirs();
				}
				FileOutputStream out = new FileOutputStream(Fout);
				BufferedOutputStream bos = new BufferedOutputStream(out);
				int b;
				while ((b = bis.read()) != -1) {
					bos.write(b);
				}
				bos.close();
				out.close();
				System.out.println(Fout + "解压成功");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			close(in);
			close(bis);
		}
	}
	private static void close(BufferedInputStream bis) {
		if (bis != null) {
			try {
				bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	private static void close(ZipInputStream in) {
		if (in != null) {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 去掉后缀
	 * 
	 * @param fileName
	 * @param suffix
	 * @return
	 */
	private static String removeSuffix(String fileName, String suffix) {
		int index = fileName.toLowerCase().lastIndexOf(suffix);
		if (index > -1) {
			return fileName.substring(0, index);
		} else {
			return fileName;
		}
	}

	public static void unTargz(String fileName, String dir) {
		BufferedInputStream bufferedInputStream = null;
		FileInputStream fis = null;
		GZIPInputStream is = null;
		ArchiveInputStream in = null;
		File tarFile = new File(fileName);
		try {
			fis = new FileInputStream(tarFile);
			is = new GZIPInputStream(new BufferedInputStream(fis));
			in = new ArchiveStreamFactory().createArchiveInputStream("tar", is);
			bufferedInputStream = new BufferedInputStream(in);
			TarArchiveEntry entry = (TarArchiveEntry) in.getNextEntry();

			while (entry != null) {
				if(entry.isFile()){
					String name = entry.getName();
//					name = name.substring(dirLength+1,name.length());
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					int b;
					while ((b = bufferedInputStream.read()) != -1) {
						baos.write(b);
					}
					byte[] buffer = baos.toByteArray();
					String result = new String(buffer, "UTF-8");
//					map.put(name, result);
				}
				
				entry = (TarArchiveEntry) in.getNextEntry();
			}
			is.close();
			in.close();
			fis.close();
			System.out.println("压缩文件："+fileName+"完毕");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferedInputStream != null) {
					bufferedInputStream.close();
				}
				if (is != null) {
					is.close();
				}
				if (in != null) {
					in.close();
				}
				if (fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}		
	}
	
	public static String readFile(String filePath) {
		StringBuffer sb = new StringBuffer();
		BufferedReader input = null;
		try {
			input = new BufferedReader(new InputStreamReader(
					new FileInputStream(filePath), "UTF-8"));
			String line = null;
			while ((line = input.readLine()) != null) {
				sb.append(line+"\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	public static boolean writeFile(String path, String content) {
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
			byte[] contentInBytes = content.getBytes(Charset.forName("UTF-8"));
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

	private static void renameFile(String path, int n) {
		Map<String,String> map = new HashMap<>();
		File[] folders = new File(path).listFiles();
		for(File folder:folders){
			if(folder.isDirectory()){
				String folderPath = folder.getAbsolutePath();
				System.out.println(folderPath);
				File[] files = folder.listFiles();
				for(File file:files){
					if(file.isFile()){
						String srcName = file.getName();
						String destName = getNfileName(srcName,n);
						if(!destName.equals(file.getName())){
							map.put(destName,srcName);
							File nfile = new File(folderPath+File.separator+destName);
							System.out.println(nfile.getAbsolutePath());
							file.renameTo(nfile);
						}
					}					
				}
			}			
		}
		
		if(map.size() > 0){
			for(File folder:folders){
				if(folder.isDirectory()){
					File[] files = folder.listFiles();
					for(File file:files){
						if(file.isFile()){
							if(map.containsKey(file.getName())){
								changeClassName(file, map.get(file.getName()), file.getName());
							}
						}					
					}
				}			
			}
		}
	}
	
	private static void changeClassName(File file, String srcName, String destName) {
		String content = readFile(file.getAbsolutePath());
		content = content.replace("public class "+srcName.replace(".java", ""), "public class "+destName.replace(".java", ""));
		writeFile(file.getAbsolutePath(), content);		
	}
	private static String getNfileName(String name, int n) {
		int index = name.indexOf("_");
		if(index == -1)
			return name;
		
		String num = name.substring(1,index);
		int zeroCnt = n - num.length();
		if(zeroCnt <= 0)
			return name;		
		return name.substring(0,1)+repeatZero(zeroCnt)+num+name.substring(index);
	}
	
	private static String repeatZero(int num) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i < num ;i++){
			sb.append("0");
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		renameFile("C:/workspace/lqb/git-java/util/src/main/java/com/sangbill/leecode",4);

	}
	
}
