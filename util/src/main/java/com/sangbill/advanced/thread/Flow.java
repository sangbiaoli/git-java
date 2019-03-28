package com.sangbill.advanced.thread;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
  
public class Flow {  
	private static ExecutorService pool = Executors.newFixedThreadPool(40);
	LinkedBlockingQueue<String> argQueue = new LinkedBlockingQueue<String>();
	LinkedBlockingQueue<String> resultQueue = new LinkedBlockingQueue<String>();
	List<String> resultList = new ArrayList<String>();
	Boolean b = true; //标识能否放到列表中
	private static int size = 3;
	private static int total = 13;
	public synchronized void putArg(String arg) {  
	    	argQueue.offer(arg);
	        notify();// 唤醒阻塞队列的某线程到就绪队列  
	        System.out.println("----放入参数："+arg);  
	}  
   
	public synchronized Object getArg() { 
        while(argQueue.size() == 0) {  
            try {  
                wait();  
            } catch (InterruptedException e) {  
            }
        }  
        String arg = argQueue.poll();
        pool.execute(new CodeThread(arg));
        System.out.println("----拿到参数:"+arg);  
        return arg;
    }  
    
	public  class CodeThread implements Runnable {
    	private String code;
		public void run() {
			try {
				Thread.sleep(333);
				resultQueue.offer("处理参数:"+code);
				notifyAll();
			} catch (InterruptedException e) {			
				e.printStackTrace();
			}
		}
		public CodeThread(String code) {
			this.code = code;
		}

    }
   
	public synchronized void getResult() {  
        while(resultQueue.size() == 0 || !b) {  
            try {  
                wait();  
            } catch (InterruptedException e) {  
            }
        }  
        if(resultList.size() == size){
        	b = false;
        	notify();
        }
    }
	
	public void handleResult() {
		while(b) {  
            try {  
                wait();
            } catch (InterruptedException e) {  
            }
        }  
		System.out.println("批量输出结果：");
		for (int i = 0; i < resultList.size(); i++) {
			System.out.println(resultList.get(i));
		}
		resultList.clear();
		b = false;
		notify();
	}  
	static class GetResultThread extends Thread{  
        private Flow plate;  
        public GetResultThread(Flow plate){  
            this.plate=plate;  
        }  
          
        public void run(){  
            while(true){
                plate.getResult();  
            }  
        }  
    }  
    static class GetArgThread extends Thread{  
        private Flow plate;  
        public GetArgThread(Flow plate){  
            this.plate=plate;  
        }  
          
        public void run(){  
            while(true){
                plate.getArg();  
            }  
        }  
    }  
    static class HandleResultThread extends Thread{  
        private Flow plate;  
        public HandleResultThread(Flow plate){  
            this.plate=plate;  
        }  
          
        public void run(){  
            while(true){
            	plate.handleResult();
            }  
        }  
    }   
    public static void main(String args[]){  
        try {  
            Flow plate = new Flow();
            Thread getArg = new Thread(new GetArgThread(plate));  
            Thread getResult = new Thread(new GetResultThread(plate));  
            Thread handleResult = new Thread(new HandleResultThread(plate));          
            getArg.start(); 
            getResult.start();
            handleResult.start();
            for (int i = 0; i < total; i++) {
            	plate.putArg(i+"");
            	Thread.sleep(100);
            }
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
        System.out.println("测试结束");  
    }

	
}  