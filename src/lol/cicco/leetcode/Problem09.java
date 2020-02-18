package lol.cicco.leetcode;

public class Problem09 {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        if(x < 10) return true;

        int[] arr = new int[10]; // Integer.MAX_VALUE length is 10.

        int idx = arr.length - 1;
        while(x != 0) {
            int val = x % 10;
            arr[idx--] = val;

            x /= 10;
        }
        idx ++;
        int start = idx;
        int end = arr.length - 1;
        while(start < end) {
            if(arr[start++]  != arr[end--]) {
                return false;
            }
        }
        return true;
    }
}
