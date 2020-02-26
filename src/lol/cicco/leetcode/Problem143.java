package lol.cicco.leetcode;

public class Problem143 {
    public void reorderList(ListNode head) {
        if(head == null) return;

        ListNode pre = null;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }

        // 中点
        if(fast != null) {
            pre = slow;
            slow = slow.next;
        }
        // 将链表断为两个
        pre.next = null;
        // 反转剩余链表
        ListNode reverse = new ListNode(0);
        while(slow != null) {
            ListNode remain = slow.next;
            slow.next = reverse.next;
            reverse.next = slow;

            slow = remain;
        }

        slow = reverse.next;
        while(slow != null) {
            // 插入中间缝隙
            ListNode reverseRemain = slow.next;
            slow.next = head.next;
            head.next = slow;
            head = head.next.next;
            slow = reverseRemain;
        }
    }

    // 双端队列
    /*
    public void reorderList(ListNode head) {
        LinkedList<ListNode> list = new LinkedList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        if (list.size() <= 2) {
            return;
        }
        ListNode cur = null;
        while (!list.isEmpty()) {
            if (cur == null) {
                cur = list.pollFirst();
            } else {
                cur.next = list.pollFirst();
                cur = cur.next;
            }
            cur.next = list.pollLast();
            cur = cur.next;
        }
        if (cur != null) {
            cur.next = null;
        }
    }
     */

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
