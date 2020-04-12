package com.sangbill.leecode.tree;

class T0572_isSubtree {
	public static boolean isSubtree(TreeNode s, TreeNode t) {
		if(sameTree(s,t)){
			return true;
		}
		
		if(s != null){
			return isSubtree(s.left, t) || isSubtree(s.right, t);
		}
		return false;
	}

	public static boolean sameTree(TreeNode s, TreeNode t) {
		if (s == null || t == null) {
			return (s == null && t == null);
		}
		System.out.println(String.format("s.val = %s,t.val = %s", s.val,t.val));
		return (s.val == t.val) && sameTree(s.left, t.left) && sameTree(s.right, t.right);
	}
	
	public static void main(String[] args) {
		TreeNode s = new TreeNode(new Integer[]{3,4,5,1,2,null,null,0});
		TreeNode t = new TreeNode(new Integer[]{4,1,2});
		System.out.println(isSubtree(s,t));
	}
}