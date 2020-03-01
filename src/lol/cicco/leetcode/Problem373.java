package lol.cicco.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class Problem373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1.length * nums2.length < k) {
            k = nums1.length * nums2.length;
        }
        List<List<Integer>> list = new ArrayList<>(k);
        TreeMap<Integer, List<List<Integer>>> treeMap = new TreeMap<>();
        for (int item1 : nums1) {
            for (int item2 : nums2) {
                int sum = item1 + item2;
                List<Integer> arr = new ArrayList<>(2);
                arr.add(item1);
                arr.add(item2);
                List<List<Integer>> val = treeMap.getOrDefault(sum, new LinkedList<>());
                val.add(arr);
                treeMap.put(sum, val);
            }
        }
        int count = 0;
        for(Integer val : treeMap.keySet()) {
            List<List<Integer>> values = treeMap.get(val);
            for(List<Integer> op : values) {
                list.add(op);
                count++;
                if(count == k) {
                    return list;
                }
            }
        }
        return list;
    }
}
