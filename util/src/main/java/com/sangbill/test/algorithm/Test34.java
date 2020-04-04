package com.sangbill.test.algorithm;

public class Test34 {

	public static ListNode reverseList(ListNode head) {
		if (head == null)
			return head;

		ListNode newHead = new ListNode(head.val);
		return reverse(head, newHead);
	}

	private static ListNode reverse(ListNode head, ListNode newHead) {
		if (head.next != null) {
			ListNode temp = new ListNode(head.next.val);
			temp.next = newHead;
			newHead = temp;
			return reverse(head.next, newHead);
		}
		return newHead;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		ListNode r = reverseList(head);
	}
}