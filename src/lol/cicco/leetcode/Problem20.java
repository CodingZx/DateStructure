package lol.cicco.leetcode;

import java.util.Stack;

public class Problem20 {
    public boolean isValid(String s) {
        if(s == null) {
            return true;
        }
        char[] vals = s.toCharArray();

        Stack<Character> stack = new Stack<>();
        for(char val : vals) {
            if(val == '(' || val == '[' || val == '{'){
                stack.push(val);
                continue;
            }
            if(stack.isEmpty()) {
                return false;
            }
            char pop = stack.pop();
            if(pop == '(' && val == ')') {
                continue;
            }
            if(pop == '[' && val == ']') {
                continue;
            }
            if(pop == '{' && val == '}') {
                continue;
            }
            return false;
        }

        return stack.isEmpty();
    }
}
