package com.sangbill.leecode.listnode;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

	public TreeNode(Integer[] nodes) {
		if(nodes.length > 0){
			//3,9,20,null,null,15,7
			this.val = nodes[0];
			Queue<TreeNode> queue = new ArrayDeque<>();
			queue.add(this);
			int i = 1;
			while(i < nodes.length){
				TreeNode root = queue.poll();
				if(nodes[i] != null){
					root.left = new TreeNode(nodes[i]);
					queue.add(root.left);
				}
				if(i + 1 < nodes.length){
					if(nodes[i + 1] != null){
						root.right = new TreeNode(nodes[i+1]);
						queue.add(root.right);
					}
				}
				i = i + 2;
			}
		}
	}

	public void print() {
		System.out.print(val+" ");
		if(this.left != null){
			this.left.print();
		}
		if(this.right != null){
			this.right.print();
		}
	}
}