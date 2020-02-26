package lol.cicco.leetcode;


public class Problem234 {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;  // 逆序链表
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            // 反转链表
            ListNode next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;

        }

        if(fast != null) { // 说明是奇数...
            slow = slow.next;
        }

        while(slow != null){
            if(pre == null || pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }

        return true;
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
