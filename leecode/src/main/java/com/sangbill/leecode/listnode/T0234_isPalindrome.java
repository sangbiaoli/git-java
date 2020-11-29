package com.sangbill.leecode.listnode;

class T0234_isPalindrome {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }

        ListNode h = new ListNode(0);
        h.next = head;
        ListNode fast = h;
        ListNode slow = h;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode p = slow.next;
        slow.next = null; //切断为两条链，开始把第二条链逆序
        p = reorder(p);

        ListNode fhead = head;
        ListNode shead = p;
        while(fhead != null && shead != null){
            if(fhead.val != shead.val){
                return false;
            }
            fhead = fhead.next;
            shead = shead.next;
        }
        return true;
    }

    private ListNode reorder(ListNode head){
        ListNode temp = head;
        ListNode q = head.next;
        temp.next = null;
        while(q != null){
            head = q;
            q = q.next;
            head.next = temp;
            temp = head;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1,2,2,2,1});
        T0234_isPalindrome su = new T0234_isPalindrome();
        System.out.println(su.isPalindrome(head));
    }
}