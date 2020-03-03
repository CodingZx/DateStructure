package lol.cicco.leetcode;

public class Problem520 {
    public boolean detectCapitalUse(String word) {
        char[] arr = word.toCharArray();
        if(arr[0] >= 'A' && arr[0] <= 'Z'){
            // 首字母大写
            if(arr.length == 1) {
                return true;
            }
            boolean secondUp = arr[1] >= 'A' && arr[1] <= 'Z';
            for(int i=2;i<arr.length;i++){
                if(secondUp) {
                    if(arr[i] < 'A' || arr[i] > 'Z') { // 必须全大写
                        return false;
                    }
                } else {
                    if(arr[i] < 'a' || arr[i] > 'z') { // 必须全小写
                        return false;
                    }
                }
            }
        } else {
            // 首字母小写
            for(int i=1;i<arr.length;i++){
                if(arr[i] >= 'A' && arr[i] <= 'Z') {
                    return false;
                }
            }
        }
        return true;
    }
}
