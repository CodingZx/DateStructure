package lol.cicco.leetcode;

public class Problem328 {
    public ListNode oddEvenList(ListNode head) {
        ListNode left = new ListNode(0);
        ListNode leftHead = left;
        ListNode right = new ListNode(0);
        ListNode rightHead = right;

        int i = 0;
        while(head != null) {
            ListNode remain = head.next;
            head.next = null;
            if(i % 2 == 0) {
                left.next = head;
                left = left.next;
            } else{
                right.next = head;
                right = right.next;
            }
            ++i;
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
