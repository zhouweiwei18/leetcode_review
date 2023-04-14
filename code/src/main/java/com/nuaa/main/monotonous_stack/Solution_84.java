package com.nuaa.main.monotonous_stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_84 {

    // 单调栈解法
    public int largestRectangleArea(int[] heights) {
        // 创建单调递减栈
        Deque<Integer> stack = new ArrayDeque<>();
        int sum = 0;
        // 重新设置height
        int[] newHeight = new int[heights.length * 2];
        newHeight[0] = 0;
        newHeight[heights.length] = 0;
        for (int i = 1; i < newHeight.length - 1; i++) {
            newHeight[i] = heights[i - 1];
        }
        heights = newHeight;
        stack.push(0);
        for (int i = 0; i < heights.length; i++) {
            // 情况 1
            if (stack.isEmpty() || heights[i] > heights[stack.peek()]) {
                stack.push(i);
                continue;
            }
            // 情况 2
            if (heights[i] == heights[stack.peek()]) {
                stack.pop();
                stack.push(i);
                continue;
            }
            // 情况 3
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int mid = stack.pop();
                if (!stack.isEmpty()) {
                    int w = i - stack.peek() - 1;
                    int h = heights[mid];
                    sum = Math.max(sum, w * h);
                }
            }
            stack.push(i);
        }
        return sum;
    }

    // 双指针解法
    /*public int largestRectangleArea(int[] heights) {
        int sum = 0;
        for (int i = 0; i < heights.length; i++) {
            int left = i;
            int right = i;
            for (; right < heights.length; right++)
                if (heights[right] < heights[i]) break;
            for (; left >= 0; left--)
                if (heights[left] < heights[i]) break;
            int w = right - left - 1;
            int height = heights[i];
            sum = Math.max(sum, w * height);
        }
        return sum;
    }*/
}
