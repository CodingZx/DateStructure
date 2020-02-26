package lol.cicco.leetcode;

public class Problem148 {
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
    public ListNode sortList(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        // 计算长度
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        } // O(n)

        for (int step = 1; step < len; step *= 2) {
            ListNode temp = pre.next;
            ListNode tail = pre;

            while (temp != null) {
                ListNode left = temp;
                ListNode right = cut(left, step);
                temp = cut(right, step); // 将left right变成单独的链表进行合并

                tail.next = mergeTwoLists(left, right);
                while (tail.next != null) {
                    tail = tail.next; // 将指针指向尾部.. 方便后续cut之后归并排序 然后合并回原链表
                }
            }
        }
        return pre.next;
    }

    private ListNode cut(ListNode node, int size) {
        ListNode p = node;
        for (int i = size ; i > 1 && p != null; i--) { // 如果size为1 那直接将当前node.next设置为null即可..
            p = p.next;
        }
        if (p == null) {
            return null;
        }
        ListNode next = p.next;
        p.next = null; // 终止链表
        return next;
    }

    // 21题合并链表 无额外空间
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head;

        if (l1.val > l2.val) {
            head = l2;
            l2 = l2.next;
        } else {
            head = l1;
            l1 = l1.next;
        }

        ListNode node = head;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                node.next = l2;
                l2 = l2.next;
            } else {
                node.next = l1;
                l1 = l1.next;
            }
            node = node.next;
        }

        while (l1 != null) {
            node.next = l1;
            l1 = l1.next;
            node = node.next;
        }

        while (l2 != null) {
            node.next = l2;
            l2 = l2.next;
            node = node.next;
        }
        return head;
    }

    /*
    public ListNode sortList(ListNode head) {
        // 非常数空间复杂度
        TreeMap<Integer, Integer> map = new TreeMap<>();
        ListNode root = head;
        while(root != null) {
            Integer count = map.get(root.val);
            if(count == null) {
                map.put(root.val, 1);
            } else {
                map.put(root.val, count+1);
            }
            root = root.next;
        }
        ListNode n = head;

        for(Integer val : map.keySet()) {
            int count = map.get(val);
            for(int i=0;i<count;i++){
                n.val = val;
                n = n.next;
            }
        }
        return head;
    }
    */
}
