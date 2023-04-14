package com.nuaa.main.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_255 {

    class MinStack {
        Deque<Integer> stack;
        Deque<Integer> min_stack;

        public MinStack() {
            stack = new ArrayDeque<>();
            min_stack = new ArrayDeque<>();
        }

        public void push(int val) {
            stack.push(val);
            if (min_stack.isEmpty() || min_stack.peek() >= val)
                min_stack.push(val);
        }

        public void pop() {
            int value = stack.pop();
            if (value == min_stack.peek())
                min_stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min_stack.peek();
        }
    }
}
