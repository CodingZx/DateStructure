package lol.cicco.leetcode;

public class Problem725 {

    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode tmp = root;
        int len = 0;
        while (tmp != null) {
            tmp = tmp.next;
            len++;
        }

        if(len <= k) {
            ListNode[] res = new ListNode[k];
            int idx = 0;
            while(root != null) {
                res[idx++] = root;
                ListNode rem = root.next;
                root.next = null;
                root = rem;
            }
            return res;
        }
        tmp = root;

        int lengthAddOneCount = len % k;
        ListNode[] nodes = new ListNode[lengthAddOneCount == 0 ? k : k + 1];

        int elementSize = len / k;
        int count = 0;
        int nowProcess = 0;
        ListNode splitHead = null;
        int listNodeIdx = 0;
        while(tmp != null) {
            if(nowProcess == 0) {
                splitHead = tmp;
            }

            nowProcess ++;

            if(nowProcess >= elementSize) {
                if(count < lengthAddOneCount) {
                    tmp = tmp.next;
                    count ++;
                }
                ListNode remain = tmp.next;
                tmp.next = null;
                nodes[listNodeIdx++] = splitHead;
                tmp = remain;

                splitHead = null;
                nowProcess = 0;
            } else {
                tmp = tmp.next;
            }
        }
        return nodes;
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
