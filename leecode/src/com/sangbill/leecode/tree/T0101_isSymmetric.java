package com.sangbill.leecode.tree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class T101_isSymmetric {
    public static boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        
        if(root.left == null || root.right == null){
            return root.left == root.right;
        }

        return isSymmetric(root.left,root.right);
    }

    public static boolean isSymmetric(TreeNode left,TreeNode right){
        if(!isSameNode(left,right))
            return false;

        if(left != null){
        	System.out.println(String.format("left:%s,right:%s", left.val,right.val));
            return isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
        }
        return true;
    }

    public static boolean isSameNode(TreeNode left,TreeNode right){
        if(left == null || right == null){
            return left == right;
        }
        return left.val == right.val;

    }
    
    public static void main(String[] args) {
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(2);
    	root.right = new TreeNode(2);
    	root.left.left = new TreeNode(3);
    	root.left.right = new TreeNode(4);
    	root.right.left = new TreeNode(4);
    	root.right.right = new TreeNode(3);
    	System.out.println(isSymmetric(root));
	}
}
