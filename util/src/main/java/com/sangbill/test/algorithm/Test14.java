package com.sangbill.test.algorithm;

public class Test14 {
	
	public static TreeNode lcaDeepestLeaves(TreeNode root) {
		if(root == null){
			return null;
		}
		int left = depth(root.left);
		int right = depth(root.right);
		if(left == right){
			return root;
		}else if(left > right){
			return lcaDeepestLeaves(root.left);
		}else{
			return lcaDeepestLeaves(root.right);
		}
    }


	private static int depth(TreeNode root) {
		if(root == null){
			return 0;
		}
		int left = depth(root.left);
		int right = depth(root.right);
		return 1 + Math.max(left, right);
	}


	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		TreeNode node = lcaDeepestLeaves(root);
		node.print();
	}
}
