package lol.cicco.leetcode;

import lol.cicco.leetcode.struct.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem23 {


    public ListNode mergeKLists(ListNode[] lists){
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        ListNode root = new ListNode(0);
        ListNode cur = root;
        for (ListNode list : lists) {
            if (list != null) {
                queue.offer(list);
            }
        }

        while(!queue.isEmpty()){
            cur.next = queue.poll();
            cur = cur.next;
            if (cur.next != null) {
                queue.offer(cur.next);
            }
        }
        return root.next;

    }

    /*
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        ListNode l1 = lists[0];
        for(int i=1;i<lists.length;i++){
            l1 = mergeTwoLists(l1, lists[i]);
        }
        return l1;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 链式归并
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode head;

        if(l1.val > l2.val) {
            head = l2;
            l2 = l2.next;
        } else {
            head = l1;
            l1 = l1.next;
        }

        ListNode node = head;

        while(l1 != null && l2 != null) {
            if(l1.val > l2.val) {
                node.next = l2;
                l2 = l2.next;
            } else {
                node.next = l1;
                l1 = l1.next;
            }
            node = node.next;
        }

        if(l1 != null) {
            node.next = l1;
        }

        if(l2 != null) {
            node.next = l2;
        }
        return head;
    }
     */
}
