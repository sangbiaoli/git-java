/* 
 * Copyright (c) 2018, CENTRIN.CIYUN.LTD. All rights reserved.
 */
package com.sangbill.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import com.alibaba.fastjson.JSONObject;
import com.sangbill.entity.AntTree;
import com.sangbill.entity.Tree;

/**
 * TODO(描述这个类的作用) 
 * @author liqiangbiao
 * @date 2018年11月16日
 */
public class AntTreeUtil {
    public static void main(String[] args) {
        Tree root = new Tree("1","0","根节点");
        Tree t1 = new Tree("001","1","一级节点1");
        Tree t2 = new Tree("002","1","一级节点2");
        Tree t1T1 = new Tree("001001","001","二级节点1-1");
        Tree t1T2 = new Tree("001002","001","二级节点1-2");
        Tree t2T1 = new Tree("002001","002","二级节点2-1");
        Tree t2T2 = new Tree("002002","002","二级节点2-2");
        
        List<Tree> treeList = Arrays.asList(
            root,
            t1,
            t2,
            t1T1,
            t1T2,
            t2T1,
            t2T2
        );
        
        HashMap<String,List<Tree>> map = new HashMap<String,List<Tree>>();
        for (Tree tree : treeList) {
            List<Tree> items = map.get(tree.getParentId());
            if(items == null){
                items = new ArrayList<Tree>();
            }
            items.add(tree);
            map.put(tree.getParentId(),items);
        }
        
        AntTree rootTree = new AntTree(root);
        revAddNode(rootTree,map);
        JSONObject obj = (JSONObject) JSONObject.toJSON(rootTree);
        System.out.println(obj.toJSONString());
    }

    private static void revAddNode(AntTree rootTree, HashMap<String, List<Tree>> map) {
        List<Tree> items = map.get(rootTree.getKey());
        if(items != null && items.size() > 0){
            List<AntTree> children = new ArrayList<AntTree>();
            for (Tree tree : items) {
                AntTree antTree = new AntTree(tree);
                revAddNode(antTree, map);
                children.add(antTree);
            }
            rootTree.setChildren(children);
        }
    }
}
