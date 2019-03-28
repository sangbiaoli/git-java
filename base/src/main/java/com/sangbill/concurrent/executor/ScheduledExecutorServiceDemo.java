/* 
 * Copyright (c) 2019, CENTRIN.CIYUN.LTD. All rights reserved.
 */
package com.sangbill.concurrent.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * TODO(描述这个类的作用) 
 * @author liqiangbiao
 * @date 2019年3月27日
 */
public class ScheduledExecutorServiceDemo {
    class BeeperControl{
        private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        
        public void beepForAnHour(){
            final Runnable beeper = new Runnable() {          
                @Override
                public void run() {
                    System.out.println("beep");
                }
            };
            
            final ScheduledFuture<?> beeperHandle = scheduler.scheduleAtFixedRate(beeper, 10, 10, TimeUnit.SECONDS);
            scheduler.schedule(new Runnable() {
                @Override
                public void run() {
                    beeperHandle.cancel(true);
                }
            }, 60, TimeUnit.SECONDS);
        }        
    }
}
