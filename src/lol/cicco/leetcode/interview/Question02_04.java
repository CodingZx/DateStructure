package lol.cicco.leetcode.interview;


public class Question02_04 {

    public ListNode partition(ListNode head, int x) {
        if(head == null) return head;
        ListNode left = new ListNode(0);
        ListNode leftNode = left;
        ListNode right = new ListNode(0);
        ListNode rightNode = right;

        while(head != null) {
            ListNode remain = head.next;
            head.next = null;
            if(head.val < x) {
                leftNode.next = head;
                leftNode = leftNode.next;
            } else {
                rightNode.next = head;
                rightNode = rightNode.next;
            }
            head = remain;
        }

        leftNode.next = right.next;

        return left.next;
    }


    public static class ListNode {
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
