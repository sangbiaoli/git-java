package com.sangbill.advanced.process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProcessTest{
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(1);
		executor.execute(new ProcessTask());
	} 
	
	/**
	 * 进程任务类
	 * @author liqiangbiao
	 *
	 */
	public static class ProcessTask implements Runnable {
		public static final String FIRE_FOX = "firefox.exe";				//火狐浏览器进程
		public static final String IE = "iexplore.exe";						//IE浏览器进程
		public static final String IE_DRIVER_SERVER = "IEDriverServer.exe";//IEDriverServer进程
		public static final String NTSD = "ntsd.exe";					  //终止进程的进程
		public static final String MSHTA = "mshta.exe";					  //IE解释html的进程(js报错)
		public static final int FIVE_MINUTE = 1000*0;
		public static final List<String> killProcesses = Arrays.asList(FIRE_FOX,IE,IE_DRIVER_SERVER,MSHTA);
		
		//记录前五分钟的Firefox,IE,IEDriverServer进程号缓存
		public static List<String> preProcessCache = new ArrayList<String>();
		public static List<String> curProcessCache = new ArrayList<String>();
		public void run() {
			try {
				while(true){	
					this.findAndKillProcess();
					Thread.sleep(FIVE_MINUTE);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		public  void findAndKillProcess() {
			Process p = null;
			int count = 0;
			try {
				p = Runtime.getRuntime().exec("tasklist");
			} catch (IOException e) {
				e.printStackTrace();
			}
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			System.out.println(format.format(new Date())+",Total procs:"+preProcessCache.size()+"\nstarting to kill...........................");
			if(p != null){
				BufferedReader bw = new BufferedReader(new InputStreamReader(p.getInputStream()));
				String str = "";
				while (true) {
					try {
						str = bw.readLine();
						if (str != null) {		
							String[] processInfo = str.split("\\s{1,}");					
							if(killProcesses.contains(processInfo[0])){						
								//判断是否已经在进程缓存中,在则删除，不在则添加到缓存中
								if(preProcessCache.contains(processInfo[1])){								
									++count;
									//Runtime.getRuntime().exec("tskill "+processInfo[1]);
									Runtime.getRuntime().exec("ntsd -c q -p "+processInfo[1]);
									System.out.println(processInfo[0]+":"+processInfo[1]+",count:"+count);
								}else{
									curProcessCache.add(processInfo[1]);
								}							
							} 
						}else{
							break;
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				//清除上一次的所有进程缓存
				preProcessCache.clear();
				//这一次的所有进程缓存->上一次的所有进程缓存中							
				preProcessCache.addAll(curProcessCache);
				//清除这一次的所有进程缓存
				curProcessCache.clear();
			}
			System.out.println("Total killed "+count+" processes, done!\n");
		}
	}
}