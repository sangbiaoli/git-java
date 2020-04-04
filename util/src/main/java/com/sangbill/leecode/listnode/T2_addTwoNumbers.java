package com.sangbill.leecode.listnode;

public class T2_addTwoNumbers {

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		
		ListNode l3 = new ListNode(l1.val + l2.val);
		ListNode next = l3;
		while(l1.next != null && l2.next != null){
			l1 = l1.next;
			l2 = l2.next;
			next.next = new ListNode(l1.val + l2.val);
			next = next.next;
		}
		while(l1.next != null){
			l1 = l1.next;
			next.next = new ListNode(l1.val);
			next = next.next;
		}
		while(l2.next!= null){
			l2 = l2.next;
			next.next = new ListNode(l2.val);
			next = next.next;
		}
		
		//ajust
		next = l3;
		boolean b;
		if(next.val >= 10){
			next.val = next.val - 10;
			b = true;
		}else{
			b = false;
		}
		while(next.next != null){
			next = next.next;
			if(b){
				next.val = next.val + 1;
			}
			if(next.val >= 10){
				next.val = next.val - 10;
				b = true;
			}else{
				b = false;
			}
		}
		if(b){
			next.next = new ListNode(1);
		}
		return l3;

	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(5);
//		l1.next = new ListNode(4);
//		l1.next.next = new ListNode(5);
//		l1.next.next.next = new ListNode(6);

		ListNode l2 = new ListNode(5);
//		l2.next = new ListNode(6);
//		l2.next.next = new ListNode(4);
		
		ListNode l3 = addTwoNumbers(l1,l2);
		print(l3);

	}

	private static void print(ListNode l3) {
		ListNode next = l3;
		while(next != null){
			System.out.print(next.val+",");
			next = next.next;
		}
		
	}
}
