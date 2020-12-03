package com.sangbill.leecode.tree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class T0814_pruneTree {
    public TreeNode pruneTree(TreeNode root) {
        return containOne(root)?root:null;
    }

    private boolean containOne(TreeNode root) {
        if(root == null){
            return false;
        }
        boolean a1 = containOne(root.left);
        boolean a2 = containOne(root.right);
        if(!a1){
            root.left = null;
        }
        if(!a2){
            root.right = null;
        }
        return (root.val == 1)||a1||a2;
    }

    public static void main(String[] args) {
        T0814_pruneTree su = new T0814_pruneTree();
        TreeNode root = su.pruneTree(new TreeNode(new Integer[]{1,1,0,1,1,0,1,0}));
        System.out.println(root.val);
    }
}