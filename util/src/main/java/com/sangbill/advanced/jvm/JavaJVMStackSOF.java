/* 
 * Copyright (c) 2018, CENTRIN.CIYUN.LTD. All rights reserved.
 */
package com.sangbill.advanced.jvm;

/**
 * TODO(描述这个类的作用) 
 * @author liqiangbiao
 * @date 2018年11月6日
 */
public class JavaJVMStackSOF {
    private int stackLength = 1;
    private void stackLeack() {
        stackLength ++;
        stackLeack();
    }

    public static void main(String[] args) throws Throwable{
        JavaJVMStackSOF com  = new JavaJVMStackSOF();
        try{
            com.stackLeack();
        }catch(Throwable e){
            System.out.println("stack length:"+com.stackLength );
            throw e;
        }
    }

}
