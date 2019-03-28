package com.sangbill.advanced.thread;
import java.util.ArrayList;  
import java.util.concurrent.Callable;  
import java.util.concurrent.ExecutorService;  
import java.util.concurrent.Executors;  
import java.util.concurrent.Future;  
  
/** 
 * @use 创建从任务中返回值的多线程，可以判断他的状态 
 * @author Bird 
 * 
 */  
  
class TaskWithResult implements Callable<String>{//实现这个接口，调用的是call()方法  
    private int id;  
    public TaskWithResult(int id){  
        this.id  = id;  
    }  
      
    public String call(){  
        return "result of TaskWithResult" + id;  
    }  
}  
  
public class CallableDemo {  
    public static void main(String[] args){  
        ExecutorService exec = Executors.newCachedThreadPool();  
        ArrayList<Future<String>>  results = new ArrayList<Future<String>>();  
        for(int i = 0; i < 10; i++){  
            results.add(exec.submit(new TaskWithResult(i)));  
        }  
        for(Future<String> fs : results){  
            try{  
                System.out.println(fs.get());//可以调用很多方法，包括是否工作等等  
            }catch(Exception e){  
                e.printStackTrace();  
            }finally{  
                exec.shutdown();  
            }  
        }  
    }  
}  