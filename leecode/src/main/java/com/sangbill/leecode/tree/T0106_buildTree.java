package com.sangbill.leecode.tree;

import java.util.HashMap;

public class T0106_buildTree {
	int postIdx;
	int[] postorder;
	int[] inorder;
	HashMap<Integer, Integer> idxMap = new HashMap<Integer, Integer>();

	public TreeNode helper(int inLeft, int inRight) {
		// if there is no elements to construct subtrees
		if (inLeft > inRight)
			return null;

		// pick up post_idx element as a root
		int root_val = postorder[postIdx];
		TreeNode root = new TreeNode(root_val);

		// root splits inorder list
		// into left and right subtrees
		int index = idxMap.get(root_val);

		// recursion
		postIdx--;
		// build right subtree
		root.right = helper(index + 1, inRight);
		// build left subtree
		root.left = helper(inLeft, index - 1);
		return root;
	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		this.postorder = postorder;
		this.inorder = inorder;
		// start from the last postorder element
		postIdx = postorder.length - 1;

		// build a hashmap value -> its index
		int idx = 0;
		for (Integer val : inorder)
			idxMap.put(val, idx++);
		return helper(0, inorder.length - 1);
	}
}