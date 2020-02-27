package lol.cicco.leetcode;

import java.util.Stack;

public class Problem445 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        while(l1 !=null) {
            stack1.push(l1);
            l1 = l1.next;
        }
        Stack<ListNode> stack2 = new Stack<>();
        while(l2 != null) {
            stack2.push(l2);
            l2 = l2.next;
        }

        ListNode head = new ListNode(0);
        ListNode node = head;
        boolean addOne = false;
        while(!stack1.isEmpty() && !stack2.isEmpty()) {
            int sum = stack1.pop().val + stack2.pop().val + (addOne ? 1 : 0);
            if(sum > 9) {
                sum -= 10;
                addOne = true;
            } else {
                addOne = false;
            }
            node.next = new ListNode(sum);
            node = node.next;
        }
        while(!stack1.isEmpty()) {
            int sum = stack1.pop().val + (addOne ? 1 : 0);
            if(sum > 9) {
                sum -= 10;
                addOne = true;
            } else {
                addOne = false;
            }
            node.next = new ListNode(sum);
            node = node.next;
        }
        while(!stack2.isEmpty()) {
            int sum = stack2.pop().val + (addOne ? 1 : 0);
            if(sum > 9) {
                sum -= 10;
                addOne = true;
            } else {
                addOne = false;
            }
            node.next = new ListNode(sum);
            node = node.next;
        }
        if(addOne) {
            node.next = new ListNode(1);
        }
        // 反转链表
        ListNode res = new ListNode(0);
        head = head.next;
        while(head != null) {
            ListNode remain = head.next;
            head.next = res.next;
            res.next = head;

            head = remain;
        }
        return res.next;
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
