package com.sangbill.leecode.listnode;


public class T109_sortedListToBST {
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
		if (head.next == null)
			return new TreeNode(head.val);

		ListNode pre = head;
		ListNode slow = pre.next;
		ListNode fast = slow.next;
		while (fast != null && fast.next != null) {
			pre = pre.next;
			slow = slow.next;
			fast = fast.next.next;
		}
		pre.next = null; // slow到达终点并冲中点断开
		TreeNode root = new TreeNode(slow.val);
		root.left = sortedListToBST(head);
		root.right = sortedListToBST(slow.next);
		return root;
	}

}
