package lol.cicco.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Problem202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        int sum = n;
        do {
            if(set.contains(sum)) {
                return false;
            }
            set.add(sum);

            sum = sum(sum);
        } while (sum != 0 && sum != 1);
        return sum != 0;
    }

    int sum(int n) {
        int sum = 0;
        while(n != 0) {
            int val = n % 10;
            sum = sum  + (val * val);
            n = n / 10;
        }
        return sum;
    }
}
