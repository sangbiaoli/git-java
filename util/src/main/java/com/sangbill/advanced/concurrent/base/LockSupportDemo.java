/* 
 * Copyright (c) 2019, CENTRIN.CIYUN.LTD. All rights reserved.
 */
package com.sangbill.advanced.concurrent.base;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * TODO(描述这个类的作用) 
 * @author liqiangbiao
 * @date 2019年3月1日
 */
public class LockSupportDemo{
    static int state = 0;
    static int count = 0;

    public static void main(String[] args) {
        Runnable r1 = new R1();
        Thread t1 = new Thread(r1);
        t1.start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        state = 1;
        LockSupport.unpark(t1);
    }

    
    public static class R1 implements Runnable {
        @Override
        public void run() {
            for (;;) {
                System.out.println("state："+state+",count:"+count);
                if(state == 0){
                    System.out.println("park this thread");
                    LockSupport.park(this);
                }else if(state == 1){
                    count++;
                    if(count == 10){
                        state = 2;
                    }
                }else if(state == 2){
                    break;
                }
            }
        }
        
    }
   
}
