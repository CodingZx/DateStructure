package lol.cicco.leetcode;

import java.util.*;

public class Problem290 {
    public boolean wordPattern(String pattern, String str) {
        String[] arr = str.split(" ");

        if(arr.length != pattern.length()) {
            return false;
        }

        Map<String, List<Integer>> map = new HashMap<>();
        Map<Character, List<Integer>> patternMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            List<Integer> values = map.getOrDefault(arr[i], new ArrayList<>());
            values.add(i);
            map.put(arr[i], values);
        }

        for(int i=0;i<pattern.length();i++){
            char c = pattern.charAt(i);
            List<Integer> values = patternMap.getOrDefault(c, new ArrayList<>());
            values.add(i);
            patternMap.put(c, values);
        }

        if(map.size() != patternMap.size()) {
            return false;
        }

        for (Character c : patternMap.keySet()) {
            List<Integer> idx = patternMap.get(c);
            String first = arr[idx.get(0)];
            for (int i = 1; i < idx.size(); i++) {
                if (first.equals(arr[idx.get(i)])) {
                    continue;
                }
                return false;
            }
        }
        return true;
    }
}
