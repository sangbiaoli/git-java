package com.sangbill.leecode.tree;

public class T0114_flatten {
	public static void flatten(TreeNode root) {
		if(root == null || (root.left == null && root.right == null))
            return;

        TreeNode left = root.left;
        TreeNode right = root.right;
        flatten(left);
        flatten(right);
        if(left != null){
            TreeNode cur = left;
            while(cur.right != null){
                cur = cur.right;
            }
            cur.right = right;
            root.right = left;
            root.left = null;
        }
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(new Integer[]{1,null,2,3});
		flatten(root);
		root.print();
	}
}