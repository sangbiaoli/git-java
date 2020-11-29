package com.sangbill.leecode.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class T0107_levelOrderBottom {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root == null)
            return list;
        sdf(root,list,0);
        Collections.reverse(list);
        return list;
    }

    public void sdf(TreeNode root,List<List<Integer>> list,int dept){
        if(root == null)
            return;

        List<Integer> temp;
        if(list.size() - 1 < dept){
            temp = new ArrayList<Integer>();
            list.add(temp);
        }
        
        temp = list.get(dept);
        temp.add(root.val);
        list.set(dept,temp);

        sdf(root.left,list,dept+1);
        sdf(root.right,list,dept+1);
    }
}
