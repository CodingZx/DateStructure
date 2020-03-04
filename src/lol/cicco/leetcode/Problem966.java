package lol.cicco.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem966 {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        // 构造wordList的map
        Map<String, List<String>> wordMap = new HashMap<>();
        for(String s : wordlist) {
            String lower = s.toLowerCase();
            List<String> words = wordMap.getOrDefault(lower, new ArrayList<>());
            words.add(s);
            wordMap.put(lower, words);

            String pattern = wordPattern(lower);
            List<String> patterns = wordMap.getOrDefault(pattern, new ArrayList<>());
            patterns.add(s);
            wordMap.put(pattern, patterns);
        }

        String[] answer = new String[queries.length];
        int idx = 0;
        for(String s : queries) {
            String lower = s.toLowerCase();

            List<String> matchList = wordMap.get(lower);
            if(matchList == null) {
                String pattern = wordPattern(lower);
                matchList = wordMap.get(pattern);
                if(matchList == null) {
                    answer[idx] = "";
                } else {
                    answer[idx] = matchList.get(0);
                }
            } else {
                answer[idx] = null;
                for(String matchStr : matchList) {
                    if(matchStr.equals(s)) {
                        answer[idx] = s;
                        break;
                    }
                }
                if(answer[idx] == null) {
                    answer[idx] = matchList.get(0);
                }
            }

            idx++;
        }

        return answer;
    }

    private String wordPattern(String str) {
        char[] arr = str.toLowerCase().toCharArray();
        for(int i=0;i<arr.length;i++){
            if(arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
                arr[i] = '_';
            }
        }
        return new String(arr);
    }
}
