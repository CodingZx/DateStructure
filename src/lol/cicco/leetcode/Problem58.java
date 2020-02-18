package lol.cicco.leetcode;

public class Problem58 {
    public int lengthOfLastWord(String s) {
        int lastWordLen = 0;
        char[] arr = s.toCharArray();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == ' ') {
                if (lastWordLen > 0) {
                    return lastWordLen;
                }
                continue;
            }
            lastWordLen++;
        }
        return lastWordLen;
    }
}
