package com.sangbill.leecode.tree;

public class T104_maxDepth {
	public int maxDepth(TreeNode root) {
		int dept = sdf(root);
		return dept;
	}

	public int sdf(TreeNode root) {
		if (root == null)
			return 0;

		int leftDept = sdf(root.left) + 1;
		int rightDept = sdf(root.right) + 1;
		return Math.max(leftDept, rightDept);
	}
}
