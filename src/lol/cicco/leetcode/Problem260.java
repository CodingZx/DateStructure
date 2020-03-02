package lol.cicco.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Problem260 {
    public int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            if(set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        int[] arr = new int[set.size()];
        int idx = 0;
        for(int val : set) {
            arr[idx++] = val;
        }
        return arr;
    }
}
