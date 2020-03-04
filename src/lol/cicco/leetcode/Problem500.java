package lol.cicco.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem500 {

    private static Map<Character, Integer> map = null;

    private void init(){
        if(map == null) {
            map = new HashMap<>();
            map.put('a', 2);
            map.put('s', 2);
            map.put('d', 2);
            map.put('f', 2);
            map.put('g', 2);
            map.put('h', 2);
            map.put('j', 2);
            map.put('k', 2);
            map.put('l', 2);
            map.put('q', 1);
            map.put('w', 1);
            map.put('e', 1);
            map.put('r', 1);
            map.put('t', 1);
            map.put('y', 1);
            map.put('u', 1);
            map.put('i', 1);
            map.put('o', 1);
            map.put('p', 1);
            map.put('z', 3);
            map.put('x', 3);
            map.put('c', 3);
            map.put('v', 3);
            map.put('b', 3);
            map.put('n', 3);
            map.put('m', 3);
        }
    }

    public String[] findWords(String[] words) {
        init();
        List<String> res = new ArrayList<>();
        for(String word: words) {
            char[] arr = word.toCharArray();
            int pre = 0;
            boolean add = true;
            for (char v : arr) {
                if (v >= 'A' && v <= 'Z') {
                    v = (char) (v - 'A' + 'a');
                }
                int line = map.get(v);
                if (pre != 0 && line != pre) {
                    add = false;
                    break;
                }
                pre = line;
            }
            if(add) {
                res.add(word);
            }
        }
        return res.toArray(new String[0]);
    }
}
