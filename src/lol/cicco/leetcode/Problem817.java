package lol.cicco.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Problem817 {

    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for(int g : G) {
            set.add(g);
        }

        int count = 0;
        int len = 0;
        while(head != null) {
            if(set.contains(head.val)) {
                len ++;
            } else {
                if(len > 0) {
                    count++;
                }
                len = 0;
            }

            head = head.next;
        }
        if(len > 0) {
            count++;
        }
        return count;
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
