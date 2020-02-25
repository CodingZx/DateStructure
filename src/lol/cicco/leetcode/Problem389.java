package lol.cicco.leetcode;

public class Problem389 {
    public char findTheDifference(String s, String t) {
        char[] char1 = s.toCharArray();
        char[] char2 = t.toCharArray();

        int sum = 0;
        for(char c : char2) {
            sum += c;
        }
        for(char c : char1) {
            sum -= c;
        }

        return (char) sum;
    }
}
