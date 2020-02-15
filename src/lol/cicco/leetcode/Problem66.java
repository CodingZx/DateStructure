package lol.cicco.leetcode;

public class Problem66 {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + 1;
            if (sum >= 10) {
                sum -= 10;
                digits[i] = sum;
            } else {
                digits[i] = sum;
                // 不需要进位..终止后续+1操作. 直接返回
                return digits;
            }
        }
        // 所有位都+1. 前面补充1
        int[] arr = new int[digits.length + 1];
        arr[0] = 1;
        System.arraycopy(digits, 0, arr, 1, digits.length);
        return arr;
    }
}
