package lol.cicco.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums1) {
            Integer count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }

        List<Integer> list = new ArrayList<>(nums2.length);
        for(int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if(count == 0) {
                continue;
            }
            list.add(num);
            map.put(num, 0);
        }
        int[] arr = new int[list.size()];
        int idx = 0;
        for(int val : list) {
            arr[idx++] = val;
        }
        return arr;
    }
}
