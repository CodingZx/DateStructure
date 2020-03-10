package lol.cicco;

import lol.cicco.leetcode.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Problem109 problem = new Problem109();

        problem.sortedListToBST(createList(new int[]{1,2,3,4,5,6,7,8,9,10, 11}));
    }
    private static Problem109.ListNode createList(int length) {
        Problem109.ListNode pre = new Problem109.ListNode(0);
        Problem109.ListNode node = pre;
        for (int i = 1; i <= length; i++) {
            node.next = new Problem109.ListNode(i);
            node = node.next;
        }
        return pre.next;
    }

    private static Problem109.ListNode createList(int[] val) {
        Problem109.ListNode pre = new Problem109.ListNode(0);
        Problem109.ListNode node = pre;
        for (int value : val) {
            node.next = new Problem109.ListNode(value);
            node = node.next;
        }
        return pre.next;
    }
}
