package lol.cicco.leetcode;

import lol.cicco.leetcode.struct.ListNode;

public class Problem86 {
    public ListNode partition(ListNode head, int x) {
        if(head == null) return null;

        ListNode leftHead = new ListNode(0);
        ListNode left = leftHead; // 左侧尾部节点

        ListNode rightHead = new ListNode(0);
        ListNode right = rightHead; // 右侧尾部节点


        while(head != null) {
            ListNode remain = head.next;
            head.next = null;

            if(head.val < x) {
                left.next = head;
                left = left.next;
            } else {
                right.next = head;
                right = right.next;
            }

            head = remain;
        }
        left.next = rightHead.next;

        return leftHead.next;
    }
}
