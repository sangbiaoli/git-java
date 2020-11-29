package com.sangbill.leecode.tree;

import java.util.ArrayList;
import java.util.List;

public class T0113_pathSum {
	
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null)
            return list;

        sdf(list,new ArrayList<Integer>(),root,sum);
        return list;
    }

    public void sdf(List<List<Integer>> list,List<Integer> temp,TreeNode root, int sum){
        if(root == null)
            return;

        temp.add(root.val);
        if(root.left == null && root.right == null){
            if(root.val == sum){
                list.add(temp);
            }
            return;
        }
        if(root.left != null){
            sdf(list,new ArrayList<Integer>(temp),root.left,sum - root.val);
        }

        if(root.right != null){
            sdf(list,new ArrayList<Integer>(temp),root.right,sum - root.val);
        }
    }
}
