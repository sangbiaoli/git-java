package com.sangbill.leecode.tree;

public class T0099_recoverTree {
	public static void recoverTree(TreeNode root) {
		if (root == null)
			return;

		TreeNode[] nodes = findAdjust(root, null, null);
		if(nodes != null){
			adjust(nodes[0],nodes[1]);
		}
	}

	public static TreeNode[] findAdjust(TreeNode root, TreeNode left, TreeNode right) {
		if (root == null)
			return null;

		TreeNode[] l = null;
		TreeNode[] r = null;

		if (root.left != null) {
			int lv = root.left.val;
			if(lv > root.val){
				l = new TreeNode[]{root, root.left};
			}
			if(left != null && left.val > lv){
				l = new TreeNode[]{root.left,left};
			}
			if(right != null && lv > right.val){
				l = new TreeNode[]{right, root.left};
			}
			if(l == null){
				l = findAdjust(root.left,left,root);
			}
		}
		if (root.right != null) {
			int rv = root.right.val;
			if (rv < root.val){
				r = new TreeNode[]{root.right, root};
			}
			if(left != null && left.val > rv){
				r = new TreeNode[]{root.right, left};
			}
			if(right != null && rv > right.val) {
				r = new TreeNode[]{right, root.right};
			}
			if(l == null){
				l = findAdjust(root.right,root,right);
			}
		}
		
		if(l == null || r == null){
			return (l == null)?r:l;
		}else{
			return (l[0].val == r[1].val)?new TreeNode[]{l[1],r[0]}:new TreeNode[]{l[0],r[1]};
		}
	}

	public static void adjust(TreeNode p, TreeNode q) {
		int tmp = p.val;
		p.val = q.val;
		q.val = tmp;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(new Integer[]{3,1,4,null,null,2});
		recoverTree(root);
		root.print();
	}
}