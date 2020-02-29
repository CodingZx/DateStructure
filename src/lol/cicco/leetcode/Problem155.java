package lol.cicco.leetcode;

import java.util.Stack;

public class Problem155 {

    public static class MinStack {

        Stack<Data> stack = new Stack<>();
        /** initialize your data structure here. */
        public MinStack() {

        }

        public void push(int x) {
            if(stack.isEmpty()) {
                stack.push(new Data(x, x));
            } else {
                Data last = stack.peek();
                stack.push(new Data(x, Math.min(last.min, x)));
            }
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return stack.peek().val;
        }

        public int getMin() {
            return stack.peek().min;
        }
    }

    static class Data {
        int val;
        int min;
        public Data(int val, int min){
            this.val = val;
            this.min = min;
        }
    }

}
