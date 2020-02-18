package lol.cicco.leetcode;

public class Problem125 {
    public boolean isPalindrome(String s) {
        // 忽略大小写
        char[] arr = s.toLowerCase().toCharArray();

        int start = 0;
        int end = arr.length - 1;
        while(start < end) {
            if(!check(arr[start])){
                start ++;
                continue;
            }
            if(!check(arr[end])) {
                end--;
                continue;
            }
            if(arr[start ++] != arr[end --]) {
                return false;
            }
        }
        return true;
    }

    private boolean check(char val) {
        if(val >= 'a' && val <= 'z') {
            return true;
        }
        if(val >= '0' && val <= '9') {
            return true;
        }
        return false;
    }
}
