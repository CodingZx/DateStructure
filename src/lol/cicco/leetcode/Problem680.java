package lol.cicco.leetcode;

public class Problem680 {
    public boolean validPalindrome(String s) {
        char[] arr = s.toCharArray();

        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            if (arr[start] != arr[end]) {
                // 左移或右移继续判断
                return check(arr, start + 1, end) || check(arr, start, end - 1);
            }
            start++;
            end--;
        }
        return true;
    }

    private boolean check(char[] arr, int start, int end) {
        while (start < end) {
            if (arr[start] != arr[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
