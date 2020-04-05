package com.sangbill.leecode.tree;

import java.util.ArrayList;
import java.util.List;

public class T0095_generateTrees {
	
	public static List<TreeNode> generateTrees(int n) {
		
		List<TreeNode> list = new ArrayList<TreeNode>();
		if(n <= 0)
			return list;
		
		list.add(new TreeNode(1));
		for (int i = 1; i <= n; i++) {
			List<TreeNode> temp = buildTree(1,i,n);
			list.addAll(temp);
		}
		list.remove(0);
		return list;
    }


	
	private static List<TreeNode> buildTree(int left, int mid, int right) {
		List<TreeNode> list =  new ArrayList<>();
		List<TreeNode> leftList = null;
		List<TreeNode> rightList = null;
		if(left < mid){
			leftList = new ArrayList<TreeNode>();
			for (int i = left; i <= mid - 1; i++) {
				leftList.addAll(buildTree(left, i, mid - 1));
			}
		}
		if(right > mid){
			rightList = new ArrayList<TreeNode>();
			for (int i = mid + 1; i <= right; i++) {
				rightList.addAll(buildTree(mid + 1, i, right));
			}
		}
		
		if(leftList == null || rightList == null){
			if(leftList == null && rightList == null){
				list.add(new TreeNode(mid));
			}else if(leftList == null){
				for (int i = 0; i < rightList.size(); i++) {
					TreeNode root = new TreeNode(mid);
					root.right = rightList.get(i);
					list.add(root);
				}
			}else if(rightList == null){
				for (int i = 0; i < leftList.size(); i++) {
					TreeNode root = new TreeNode(mid);
					root.left = leftList.get(i);
					list.add(root);
				}
			}
		}else{
			for (int i = 0; i < leftList.size(); i++) {
				for (int j = 0; j < rightList.size(); j++) {
					TreeNode root = new TreeNode(mid);
					root.left = leftList.get(i);
					root.right = rightList.get(j);
					list.add(root);
				}
			}
		}
		return list;
	}



	public static void main(String[] args) {
		List<TreeNode> list = generateTrees(5);
		for (int i = 0; i < list.size(); i++) {
			list.get(i).print();
			System.out.println();
		}
	}
}
