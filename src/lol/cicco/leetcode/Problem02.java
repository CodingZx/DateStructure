package lol.cicco.leetcode;

import lol.cicco.leetcode.struct.ListNode;

public class Problem02 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        // 前缀 不需要判断首位问题
        ListNode root = new ListNode(0);
        ListNode pre = root;
        // 进位标识
        boolean addOne = false;
        while(l1 != null && l2 != null) {
            addOne = plusNumber(l1, l2, addOne, pre);

            pre = pre.next;
            // 向前一位
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null) {
            addOne = plusNumber(l1, null, addOne, pre);
            l1 = l1.next;
            pre = pre.next;
        }
        while(l2 != null) {
            addOne = plusNumber(null, l2, addOne, pre);
            l2 = l2.next;
            pre = pre.next;
        }

        // 最后判断最高位是否需要进位, 进位补1
        if(addOne) {
            plusNumber(null, null, true, pre);
        }
        return root.next;
    }

    private boolean plusNumber(ListNode l1, ListNode l2, boolean addOne, ListNode pre) {
        int l1Num = l1 == null ? 0 : l1.val;
        int l2Num = l2 == null ? 0 : l2.val;
        int sum = l1Num + l2Num + (addOne ? 1 : 0);
        // 10以上要进位
        if(sum > 9) {
            addOne = true;
            sum -= 10;
        } else {
            addOne = false;
        }
        pre.next = new ListNode(sum);
        return addOne;
    }
}
