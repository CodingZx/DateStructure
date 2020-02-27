package lol.cicco.leetcode;

import java.util.Stack;

public class Problem150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s : tokens) {
            if(s.equals("+")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a+b);
                continue;
            }
            if(s.equals("-")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
                continue;
            }
            if(s.equals("*")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b*a);
                continue;
            }
            if(s.equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
                continue;
            }
            stack.push(Integer.parseInt(s));
        }
        return stack.pop();
    }
}
