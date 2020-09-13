package com.sangbill.leecode.tree;
class T1022_sumRootToLeaf {
    public int sumRootToLeaf(TreeNode root) {
        if(root == null)
            return 0;

        return sdf(root,0);
    }

    private int sdf(TreeNode root,int val){
        int v = (val << 1) + root.val;
        if(root.left == null && root.right == null){
            return v;
        }

        if(root.left == null){
            return sdf(root.right,v);
        }
        if(root.right == null){
            return sdf(root.left,v);
        }

        return sdf(root.left,v)+sdf(root.right,v);
    }
    
    public static void main(String[] args) {
    	T1022_sumRootToLeaf test = new T1022_sumRootToLeaf();
    	TreeNode root = new TreeNode(new Integer[]{1,0,1,0,1,0,1});
    	System.out.println(test.sumRootToLeaf(root));
	}
}