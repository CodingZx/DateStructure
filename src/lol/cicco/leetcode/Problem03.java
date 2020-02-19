package lol.cicco.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem03 {

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        char[] chars = s.toCharArray();

        Map<Character, Integer> map = new HashMap<>();

        int nowIdx = 0;
        int length = 0;
        for (int i = 0; i < chars.length; i++) {
            // 滑动区间
            // 获得上次坐标
            Integer idx = map.get(chars[i]);
            if (idx != null) {
                // 移除坐标区间内容. 减出length
                for (int z = nowIdx; z <= idx; z++) {
                    map.remove(chars[z]);
                    length--;
                }
                nowIdx = idx + 1;
            }
            // 把当前坐标作为新元素放入 长度+1
            length++;
            map.put(chars[i], i);

            if(length > maxLength) {
                maxLength = length;
            }
        }

        return maxLength;
    }
}
