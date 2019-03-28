package com.sangbill.advanced.thread;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
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
 
class TaskWithCodeResult implements Callable<String>{//实现这个接口，调用的是call()方法  
	public static final String CODE_URL = "http://quote.futures.hexun.com/2010/JsData/FRunTimeQuote.aspx?code=";
    private String code; 
    private Long marketId;
      
    public TaskWithCodeResult(String code, Long marketId) {
		this.code = code;
		this.marketId = marketId;
	}

	public String call() throws Exception {
		URL url;
		BufferedReader br = null;
		try {
			url = new URL(CODE_URL + code);
			br = new BufferedReader(new InputStreamReader(url.openStream(),"GBK"));
			String data = "";
			while (null != (data = br.readLine())) {
				if (data != null) {
					return parseItemTransaction(data, marketId);			
				}
			}
		} catch (Exception e) {
		}finally{
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	/**
	 * 处理数据
	 * @param marketId 
	 * @param count 
	 * @param data:var dataArr=['y1501', '豆油1501', 2, 5626, 5618, 38,'0.68%', 5632, 5662, 5620, 14888, 53140,-6204, 4350, 10550, 5644, 5588,5811.52, 5364.48, 5644]; FRunTimeQuote.GetData(dataArr)
							   ['AG1502','白银1502',3680,103,3666,9,3676,1,94,3593,3577,3680,3593,1030,48]
	 * @return 
	 */
	private synchronized String parseItemTransaction(String data, Long marketId) {
		StringBuilder sb = new StringBuilder();
		int start = data.indexOf("[");
		int end = data.indexOf("]");
		if(start == -1 || end == -1)
			return sb.toString();
		String[] flds = data.substring(start+1, end).split(",");
		String key = marketId+"_"+flds[0].substring(1,flds[0].length()-1);
		sb.append(flds[3]+"\t");
		sb.append(flds[4]+"\t");
		sb.append(flds[5]+"\t");
		sb.append(flds[6]+"\t");
		sb.append(flds[7]+"\t");
		sb.append(flds[8]+"\t");
		sb.append(flds[9]+"\t");
		sb.append(flds[10]+"\t");
		sb.append(flds[11]+"\t");
		sb.append(flds[12]+"\t");
		sb.append(flds[13]+"\t");
		sb.append(flds[14]+"\t");
		sb.append(flds[15]+"\t");
		sb.append(flds[16]+"\t");
		sb.append(flds[17]+"\t");
		sb.append(flds[18]+"\t");
		sb.append(flds[19]+"\t");
		sb.append("\n");
		return sb.toString();
	}
}  
  
public class CodeCallable {  

    public static void main(String[] args){  
    	StringBuilder builder = new StringBuilder();
    	builder.delete(0, builder.length());
        ExecutorService exec = Executors.newCachedThreadPool();  
        ArrayList<Future<String>>  results = new ArrayList<Future<String>>();  
        String[] codes = new String[]{"MA1601","CU1511","bb1502","WH1509"};
        for(int i = 0; i < codes.length; i++){  
            results.add(exec.submit(new TaskWithCodeResult(codes[i],1l)));  
        }  
        for(Future<String> fs : results){  
            try{  
            	builder.append(fs.get());//可以调用很多方法，包括是否工作等等  i
            }catch(Exception e){  
                e.printStackTrace();  
            }finally{  
                exec.shutdown();  
            }  
        }  
        System.out.println(builder.toString());
    }  
}  