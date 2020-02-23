package lol.cicco.leetcode;

import lol.cicco.leetcode.struct.ListNode;

public class Problem206 {

    public ListNode reverseList(ListNode head) {
        if(head == null) return null;

        ListNode pre = new ListNode(0);

        while(head != null) {
            ListNode next = head.next;
            head.next = pre.next;
            pre.next = head;
            head = next;
        }

        return pre.next;
    }
}
