package com.nuaa.main.monotonous_stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution_503 {

    // 取模运算模拟循环数组
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int size = nums.length;
        int[] ans = new int[size];
        Arrays.fill(ans, -1);
        for (int i = 0; i < size * 2; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }
            while (!stack.isEmpty() && nums[i % size] > nums[stack.peek() % size]) {
                int index = stack.pop();
                ans[index % size] = nums[i % size];
            }
            stack.push(i);
        }
        return ans;
    }


    // 将两个nums进行拼接
    /*public int[] nextGreaterElements(int[] nums) {
        int[] values = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            values[i] = nums[i];
            values[i + nums.length] = nums[i];
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[nums.length * 2];
        Arrays.fill(ans, -1);
        for (int i = 0; i < values.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }
            while (!stack.isEmpty() && values[i] > values[stack.peek()]) {
                int index = stack.pop();
                ans[index] = values[i];
            }
            stack.push(i);
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < ans.length / 2; i++) {
            res[i] = ans[i];
        }
        return res;
    }*/
}
