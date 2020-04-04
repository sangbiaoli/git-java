package com.sangbill.test.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test13 {
	
	public static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < to_delete.length; i++) {
			set.add(to_delete[i]);
		}
		
		List<TreeNode> list = new ArrayList<TreeNode>();
		addTree(root,null,set,list);
		return list;
	}
	
	private static void addTree(TreeNode root,TreeNode node,Set<Integer> set, List<TreeNode> list) {
		if(root == null)
			return;
		if(set.contains(root.val)){
			if(root.left != null){
				addTree(root.left,null,set,list);
			}
			if(root.right != null){
				addTree(root.right,null,set,list);
			}
		}else{
			if(node == null){
				node = new TreeNode(root.val);
				list.add(node);
			}
			if(root.left == null){
				node.left = null;
			}else{
				if(set.contains(root.left.val)){
					node.left = null;
					addTree(root.left.left,null,set,list);
					addTree(root.left.right,null,set,list);
				}else{
					node.left = new TreeNode(root.left.val);
					addTree(root.left,node.left,set,list);
				}
			}
			if(root.right == null){
				node.right = null;
			}else{
				if(set.contains(root.right.val)){
					node.right = null;
					addTree(root.right.left,null,set,list);
					addTree(root.right.right,null,set,list);
				}else{
					node.right = new TreeNode(root.right.val);
					addTree(root.right,node.right,set,list);
				}
			}
			
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		System.out.println(delNodes(root, new int[]{3,5}));
	}
}
