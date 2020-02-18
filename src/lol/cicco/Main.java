package lol.cicco;

import lol.cicco.leetcode.Problem09;
import lol.cicco.leetcode.struct.ListNode;

public class Main {

    public static void main(String[] args) {

        Problem09 problem = new Problem09();

        System.out.println(problem.isPalindrome(Integer.MAX_VALUE));
        System.out.println(problem.isPalindrome(10));
        System.out.println(problem.isPalindrome(121));
        System.out.println(problem.isPalindrome(11));

    }

    private static ListNode createList(int[] val) {
        ListNode pre = new ListNode(0);
        ListNode node = pre;
        for (int value : val) {
            node.next = new ListNode(value);
            node = node.next;
        }
        return pre.next;
    }

    private static ListNode createList(int length) {
        ListNode pre = new ListNode(0);
        ListNode node = pre;
        for (int i = 1; i <= length; i++) {
            node.next = new ListNode(i);
            node = node.next;
        }
        return pre.next;
    }

    private static void foreachList(ListNode node) {
        if (node == null) {
            System.out.println("list is null..");
            return;
        }
        StringBuilder builder = new StringBuilder();
        while (true) {
            builder.append(node.val);
            if (node.next == null) {
                break;
            }
            builder.append(" -> ");
            node = node.next;
        }
        System.out.println(builder.toString());
    }
}
