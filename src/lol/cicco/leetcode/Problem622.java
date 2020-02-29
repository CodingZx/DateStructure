package lol.cicco.leetcode;

import java.util.LinkedList;

public class Problem622 {

    class MyCircularQueue {

        LinkedList<Integer> list = new LinkedList<>();
        int size = 0;
        int length = 0;

        /** Initialize your data structure here. Set the size of the queue to be k. */
        public MyCircularQueue(int k) {
            length = k;
        }

        /** Insert an element into the circular queue. Return true if the operation is successful. */
        public boolean enQueue(int value) {
            if(size >= length){
                return false;
            }
            list.add(value);
            size++;
            return true;
        }

        /** Delete an element from the circular queue. Return true if the operation is successful. */
        public boolean deQueue() {
            if(size == 0) {
                return false;
            }
            list.removeFirst();
            size--;
            return true;
        }

        /** Get the front item from the queue. */
        public int Front() {
            if(isEmpty()) {
                return -1;
            }
            return list.getFirst();
        }

        /** Get the last item from the queue. */
        public int Rear() {
            if(isEmpty()) {
                return -1;
            }
            return list.getLast();
        }

        /** Checks whether the circular queue is empty or not. */
        public boolean isEmpty() {
            return size == 0;
        }

        /** Checks whether the circular queue is full or not. */
        public boolean isFull() {
            return size == length;
        }
    }
}
