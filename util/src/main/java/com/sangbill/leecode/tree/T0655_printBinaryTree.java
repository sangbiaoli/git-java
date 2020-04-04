package com.sangbill.leecode.tree;

import java.util.ArrayList;
import java.util.List;

public class T0655_printBinaryTree {

	public static List<List<String>> printTree(TreeNode root) {
        int dept = getMaxDept(root);
        int nums = (int) Math.pow(2, dept) - 1 ;
        List<List<String>> list = new ArrayList<>(dept);
        for(int i = 0; i < dept;i++){
            List<String> temp = new ArrayList<>(nums);
            for(int j = 0; j < nums;j ++){
                temp.add(j,"");
            }
            list.add(i, temp);
        }

        int index = nums/2;
        fill(root,1,index,dept,list);        
        return list;
    }

	private static void fill(TreeNode root, int curDept, int index,int treeDept, List<List<String>> list) {
		List<String> temp = list.get(curDept - 1);
		temp.set(index,root.val+"");
		int distance = (int)Math.pow(2, treeDept - curDept - 1);
		if(root.left != null){
			fill(root.left,curDept+1,index - distance,treeDept,list);
		}
		if(root.right != null){
			fill(root.right,curDept+1,index + distance,treeDept,list);
		}
	}


	public static int getMaxDept(TreeNode root) {
		int dept = 1;
		if (root.left == null && root.right == null) {
			return dept;
		} else if (root.left != null && root.right == null) {
			return dept + getMaxDept(root.left);
		} else if (root.left == null && root.right != null) {
			return dept + getMaxDept(root.right);
		} else {
			return dept + Math.max(getMaxDept(root.left), getMaxDept(root.right));
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(4);
		root.right = new TreeNode(5);
		
		System.out.println(printTree(root));
	}		
}
