package com.sangbill.leecode.tree;

import java.util.Arrays;

public class T0106_buildTree {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || inorder.length == 0)
            return null;

        int len = inorder.length;
        if(len == 1)
            return new TreeNode(inorder[0]);
        
        int val = postorder[len - 1];
        int i = 0;
        for(;i < len;i++){
            if(inorder[i] == val)
                break;
        }

        TreeNode root = new TreeNode(val);

        root.left = buildTree(
            Arrays.copyOfRange(inorder,0,i),
            Arrays.copyOfRange(postorder,0,i)
        );
        root.right = buildTree(
            Arrays.copyOfRange(inorder,i+1,len),
            Arrays.copyOfRange(postorder,i,len-1)
        );
        return root;
    }
}