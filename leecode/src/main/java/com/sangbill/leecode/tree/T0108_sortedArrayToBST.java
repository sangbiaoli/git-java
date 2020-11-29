package com.sangbill.leecode.tree;

public class T0108_sortedArrayToBST {
	 public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0)
            return null;

        TreeNode root = buildTree(nums,0,nums.length - 1);
        return root;
    }

    public TreeNode buildTree(int[] nums,int l,int r){
        if(l > r)
            return null;

        int m = l + (r - l)/2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = buildTree(nums,l,m - 1);
        root.right = buildTree(nums,m+1,r);
        return root;
    }
}
