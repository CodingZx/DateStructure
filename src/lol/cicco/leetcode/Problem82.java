package lol.cicco.leetcode;

public class Problem82 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode pre = new ListNode(0);
        ListNode node = pre;

        int showCount = 0;
        int preVal = head.val;
        while(head.next != null) {
            if(head.val == head.next.val) {
                showCount ++;
            } else {
                // 当出现前后不相等时.. 若出现次数为0 则追加
                if(showCount == 0) {
                    node.next = new ListNode(head.val);
                    node = node.next;
                } else {
                    showCount = 0; // 前面已经出现过  重置
                }
            }
            preVal = head.val;// 前一个元素值
            head = head.next;
        }
        if(preVal != head.val) { // 判断最后一个元素
            node.next = new ListNode(head.val);
        }
        return pre.next;
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
