package lol.cicco.leetcode;

public class Problem693 {
    public boolean hasAlternatingBits(int n) {
        String binary = Integer.toBinaryString(n);
        for (int i = 1; i <= binary.length() - 1; i++) {
            if (binary.charAt(i - 1) == binary.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
