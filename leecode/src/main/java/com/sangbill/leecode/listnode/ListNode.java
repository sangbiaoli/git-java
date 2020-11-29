package com.sangbill.leecode.listnode;

public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	ListNode(int[] nums){
		this.val = nums[0];
		ListNode cur = this;
		for(int i = 1;i < nums.length;i++){
			cur.next = new ListNode(nums[i]);
			cur = cur.next;
		}
	}
}