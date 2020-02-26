package lol.cicco.leetcode;

public class Problem160 {
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

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;

        while(a != b) {
            if(a == null) {
                a = headB;
            } else {
                a = a.next;
            }
            if(b == null) {
                b = headA;
            } else {
                b = b.next;
            }
        }
        return a;
    }
}
