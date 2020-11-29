package com.sangbill.leecode.listnode;

public class T0203_removeElements {

	public static ListNode removeElements(ListNode head, int val) {
		// 保证首个元素不是val
		while (head != null && head.val == val) {
			head = head.next;
		}

		if (head == null)
			return head;

		// 开始从第二个元素开始
		ListNode cur = head;
		while (cur.next != null) {
			if (cur.next.val == val) {
				cur.next = cur.next.next;
			}else{				
				cur = cur.next;
			}
		}
		return head;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		System.out.println(removeElements(head,2));
	}
}
