package lol.cicco;

import lol.cicco.leetcode.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Problem725 problem = new Problem725();

        Problem725.ListNode node1 = new Problem725.ListNode(1);
        Problem725.ListNode node2 = new Problem725.ListNode(2);
        Problem725.ListNode node3 = new Problem725.ListNode(3);
        Problem725.ListNode node4 = new Problem725.ListNode(4);
        Problem725.ListNode node5 = new Problem725.ListNode(5);
        Problem725.ListNode node6 = new Problem725.ListNode(6);
        Problem725.ListNode node7 = new Problem725.ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        Problem725.ListNode[] arr = problem.splitListToParts(node1, 10);
        System.out.println(Arrays.toString(arr));

    }

}
