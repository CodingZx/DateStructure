package lol.cicco.leetcode;

import java.util.LinkedList;
import java.util.List;

public class Problem989 {

    public List<Integer> addToArrayForm(int[] arr, int k) {
        LinkedList<Integer> list = new LinkedList<>();

        boolean addOne = false;
        for (int i = arr.length - 1; i >= 0; --i) {
            int kValue = 0;
            if (k > 0) {
                kValue = k % 10;
                // 计算前一位
                k /= 10;
            }
            int sum = kValue + arr[i] + (addOne ? 1 : 0);
            if (sum >= 10) {
                addOne = true;
                sum -= 10;
            } else {
                addOne = false;
            }
            list.addFirst(sum);
        }

        while (k > 0) {
            int kValue = k % 10;
            k /= 10;

            int sum = kValue + (addOne ? 1 : 0);
            if (sum >= 10) {
                addOne = true;
                sum -= 10;
            } else {
                addOne = false;
            }
            list.addFirst(sum);
        }
        if (addOne) {
            list.addFirst(1);
        }
        return list;
    }
}
