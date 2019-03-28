/* 
 * Copyright (c) 2018, CENTRIN.CIYUN.LTD. All rights reserved.
 */
package com.sangbill.entity;

import java.util.List;
import lombok.Data;

/**
 * TODO(描述这个类的作用) 
 * @author liqiangbiao
 * @date 2018年11月16日
 */
@Data
public class AntTree {
    
    private String title;
    private String key;
    private String value;
    private List<AntTree> children;
    
    public AntTree(Tree tree) {
        this.title = tree.getName();
        this.key = tree.getId();
        this.value = this.key;
    }
    public AntTree(){
        
    }
}
