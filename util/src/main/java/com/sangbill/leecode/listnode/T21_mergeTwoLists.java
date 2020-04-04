package com.sangbill.leecode.listnode;

public class T21_mergeTwoLists {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1  == null || l2 == null){
            return (l1 == null)?l2:l1;
        }
        

        ListNode head = new ListNode(-1);
        ListNode l3 = head;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                l3.next = new ListNode(l1.val);
                l1 = l1.next;
            }else{
                l3.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            l3 = l3.next;
        }
        if(l1 != null){
            l3.next = l1;
        }
        if(l2 != null){
            l3.next = l2;
        }
        return head.next;
    }
	

}
