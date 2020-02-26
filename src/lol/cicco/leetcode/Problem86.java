package lol.cicco.leetcode;

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

    static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
