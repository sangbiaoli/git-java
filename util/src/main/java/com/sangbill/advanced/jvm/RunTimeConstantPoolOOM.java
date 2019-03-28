/* 
 * Copyright (c) 2018, CENTRIN.CIYUN.LTD. All rights reserved.
 */
package com.sangbill.advanced.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO(描述这个类的作用) 
 * @author liqiangbiao
 * @date 2018年11月6日
 */
public class RunTimeConstantPoolOOM {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());   
        }
    }
}
