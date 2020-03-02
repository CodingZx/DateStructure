package lol.cicco.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem137 {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int n : nums) {
            int count = map.getOrDefault(n, 3);
            if(count == 1) {
                map.remove(n);
            } else {
                map.put(n, count - 1);
            }
        }
        return map.keySet().iterator().next();
    }
}
