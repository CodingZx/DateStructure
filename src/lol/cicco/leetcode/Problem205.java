package lol.cicco.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem205 {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> a1Map = new HashMap<>();
        Set<Character> b1Set = new HashSet<>();

        char[] a1 = s.toCharArray();
        char[] b1 = t.toCharArray();
        for (int i = 0; i < a1.length; i++) {
            if (a1Map.containsKey(a1[i])) {
                char v = a1Map.get(a1[i]);
                if(b1[i] != v) {
                    return false;
                }
            } else {
                if(b1Set.contains(b1[i])) {
                    return false;
                }
            }
            b1Set.add(b1[i]);
            a1Map.put(a1[i], b1[i]);
        }
        return true;
    }
}
