package com.sangbill.leecode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T0103_zigzagLevelOrder {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root == null)
            return list;

        dfs(root,1,list);
        if(list.size() >= 2){
            for(int i = 1;i<list.size();i=i+2){
                Collections.reverse(list.get(i));
            }
        }
        return list;
    }

    public  void dfs(TreeNode root,int level,List<List<Integer>> list){
        if(root == null)
            return;
        
        if(level > list.size()){
            list.add(new ArrayList());
        }
        list.get(level - 1).add(root.val);
        dfs(root.left,level+1,list);
        dfs(root.right,level+1,list);
    }
}
