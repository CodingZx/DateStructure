package lol.cicco.leetcode;

import java.util.*;

public class Problem224 {
    public int calculate(String s) {
        char[] arr = s.toCharArray();

        Stack<Integer> tmpStack = new Stack<>();

        Stack<Integer> values = new Stack<>();
        Stack<Character> signs = new Stack<>();

        String[] tmpArr = new String[0];

        boolean preNum = false;
        for (char c : arr) {
            if (c == ' ') {
                preNum = false;
                continue;
            }
            if (c == '(') {
                signs.push(c);
                preNum = false;
                continue;
            }
            if (c == ')') {
                List<String> ops = new ArrayList<>(signs.size() + values.size());
                while (signs.peek() != '(') {
                    ops.add(String.valueOf(signs.pop()));
                    ops.add(String.valueOf(values.pop()));
                }
                signs.pop();
                ops.add(String.valueOf(values.pop()));
                Collections.reverse(ops);
                values.push(evalRPN(ops.toArray(tmpArr), tmpStack));
                preNum = false;
                continue;
            }
            if (c == '+' || c == '-') {
                signs.push(c);
                preNum = false;
                continue;
            }

            // 数字
            if (preNum) {
                values.push((c - '0') + (values.pop() * 10));
            } else {
                values.push(c - '0');
            }
            preNum = true;
        }

        String[] arrs = new String[values.size() + signs.size()];
        int nowIdx = arrs.length - 1;
        while(!values.isEmpty()) {
            if(!signs.isEmpty()) {
                arrs[nowIdx--] = String.valueOf(signs.pop());
            }
            arrs[nowIdx--] = String.valueOf(values.pop());
        }

        return evalRPN(arrs, tmpStack);
    }


    int evalRPN(String[] arrs, Stack<Integer> tmpStack) {
        for(String s : arrs) {
            if(s.equals("+")) {
                int a = tmpStack.pop();
                int b = tmpStack.pop();
                tmpStack.push(a+b);
                continue;
            }
            if(s.equals("-")){
                int a = tmpStack.pop();
                int b = tmpStack.pop();
                tmpStack.push(b - a);
                continue;
            }
            tmpStack.push(Integer.parseInt(s));
        }
        return tmpStack.pop();
    }
}
