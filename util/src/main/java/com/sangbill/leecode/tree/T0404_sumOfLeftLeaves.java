package com.sangbill.leecode.tree;
class T0404_sumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null)
            return 0;
        
        int leftSum = sumOfLeftLeaves(root.left);
        int rightSum = sumOfLeftLeaves(root.right);
        int sum = 0;
        TreeNode leftNode = root.left;
        if(leftNode != null && leftNode.left == null && leftNode.right == null){
            sum = leftNode.val;
        }
        return leftSum+rightSum+sum;
    }
}