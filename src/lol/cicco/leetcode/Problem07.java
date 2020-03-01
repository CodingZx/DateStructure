package lol.cicco.leetcode;

public class Problem07 {
    public int reverse(int x) {
        int res = 0;
        boolean negative = x < 0;

        while (x != 0) {
            int val = x % 10;
            if (res == 0) {
                res = Math.abs(val);
            } else {
                int calc = res * 10 + Math.abs(val);
                if (calc < res || calc / res < 10) {
                    // 溢出
                    return 0;
                }
                res = calc;
            }
            x = x / 10;
        }
        return negative ? -Math.abs(res) : Math.abs(res);
    }
}
