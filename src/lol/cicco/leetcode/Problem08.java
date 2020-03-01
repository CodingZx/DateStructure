package lol.cicco.leetcode;

public class Problem08 {
    public int myAtoi(String str) {
        if(str == null || str.trim().length() == 0) {
            return 0;
        }
        int res = Integer.MIN_VALUE;

        char[] strs = str.trim().toCharArray();
        boolean negative = false;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i] != '-' && strs[i] != '+' && (strs[i] < '0' || strs[i] > '9')) {
                if(i == 0) {
                    return 0;
                }
                if (res != Integer.MIN_VALUE) {
                    break;
                }
                continue;
            }

            if(strs[i] == '-' || strs[i] == '+') {
                if(res != Integer.MIN_VALUE) {
                    // 非法字符
                    break;
                }
                if(i >= strs.length-1 || (strs[i+1] < '0' || strs[i+1] > '9')) {
                    // 不合法正负数
                    return 0;
                }
                if(strs[i] == '-') {
                    negative = true;
                }
            }

            if(strs[i] >= '0' && strs[i] <= '9') {
                if(Integer.MIN_VALUE == res) {
                    res = strs[i] - '0';
                } else {
                    int val = res * 10 + (strs[i] - '0');
                    if(res != 0) {
                        if(val < res|| val/res < 10) {
                            // 溢出
                            res = Integer.MIN_VALUE;
                            break;
                        }
                    }

                    res = val;
                }

            }

        }

        if (negative) {
            return res == Integer.MIN_VALUE ? Integer.MIN_VALUE : -res;
        }
        return res == Integer.MIN_VALUE ? Integer.MAX_VALUE : res;
    }
}
