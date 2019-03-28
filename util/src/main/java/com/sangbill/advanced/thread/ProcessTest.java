package com.sangbill.advanced.thread;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ProcessTest   
{   
    public static void main(String []args) throws InterruptedException{   
    	while(true){
    		findProcess();
    		Thread.sleep(5000);
    	}
    	
    }   
    public static void findProcess(){   
        BufferedReader br=null;   
        //下面这句是列出含有processName的进程图像名   
        Process proc;
        try{   
        	proc = Runtime.getRuntime().exec("tasklist");
			br=new BufferedReader(new InputStreamReader(proc.getInputStream()));   
			String line=null;   
			int count = 0;
			while((line=br.readLine())!=null){ 
				if(line.contains("PING.EXE")){
					count++;
				}
			}
			System.out.println("Threads of Ping.EXE is  :"+count);
        }catch(Exception e){   
            e.printStackTrace();   
        }finally{   
            if(br!=null){   
                try{   
                    br.close();   
                }catch(Exception ex){   
                }   
            }   
               
        }   
    }   
}  