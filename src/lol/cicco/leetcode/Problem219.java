package lol.cicco.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer idx = map.get(nums[i]);
            if (idx != null) {
                if (i - idx <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
