package com.nuaa.main.monotonous_stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_42 {

    // 单调栈解法
    public int trap(int[] height) {
        int sum = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (int i = 1; i < height.length; i++) {
            if (stack.isEmpty() || height[i] < height[stack.peek()]) {
                stack.push(i);
                continue;
            }
            if (height[i] == height[stack.peek()]) {
                stack.pop();
                stack.push(i);
                continue;
            }
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int mid = stack.pop();
                if (!stack.isEmpty()) {
                    int h = Math.min(height[stack.peek()], height[i]) - height[mid];
                    int w = i - stack.peek() - 1;
                    sum += h * w;
                }
            }
            stack.push(i);
        }
        return sum;
    }

    // 双指针解法，较容易理解
    /*public int trap(int[] height) {
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            if (i == 0 || i == height.length - 1) continue;
            int rHeight = height[i];
            int lHeight = height[i];
            for (int j = i + 1; j < height.length; j++)
                if (height[j] > rHeight) rHeight = height[j];
            for (int k = i; k >= 0; k--)
                if (height[k] > lHeight) lHeight = height[k];
            int h = Math.min(rHeight, lHeight) - height[i];
            if (h > 0) sum += h;
        }
        return sum;
    }*/
}
