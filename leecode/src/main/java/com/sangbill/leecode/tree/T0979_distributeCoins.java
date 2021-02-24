package com.sangbill.leecode.tree;

class T0979_distributeCoins {
    int res = 0;
    public int distributeCoins(TreeNode root) {
        res = 0;
        sdf(root);
        return res;
    }

    private int sdf(TreeNode root) {
        if (root == null)  return 0;
        int left = sdf(root.left);
        int right = sdf(root.right);
        res += Math.abs(left) + Math.abs(right);
        return root.val + left + right - 1;
    }

    public static void main(String[] args) {
        T0979_distributeCoins su = new T0979_distributeCoins();
        TreeNode root = new TreeNode(new Integer[]{3,0,0});
        int res = su.distributeCoins(root);
        System.out.println(res);
    }
}