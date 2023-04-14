package com.nuaa.main.monotonous_stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_739 {

    // 单调栈
    public int[] dailyTemperatures(int[] temperatures) {
        // 创建单调栈
        Deque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }
            // 判断与栈顶元素的大小
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                // 栈顶元素出栈
                int index = stack.pop();
                ans[index] = i - index;
            }

            stack.push(i);
        }

        return ans;
    }
}
