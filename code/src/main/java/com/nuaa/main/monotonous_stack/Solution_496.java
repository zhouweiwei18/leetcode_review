package com.nuaa.main.monotonous_stack;

import java.util.*;

public class Solution_496 {
    // 单调栈
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) map.put(nums1[i], i);
        // 创建结果集
        int[] ans = new int[nums1.length];
        Arrays.fill(ans, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums2.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                int index = stack.pop();
                if (map.containsKey(nums2[index])) {
                    int val = map.get(nums2[index]);
                    ans[val] = nums2[i];
                }
            }
            stack.push(i);
        }
        return ans;
    }

    // 暴力解法
    /*public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Arrays.fill(ans, -1);
        for (int i = 0; i < nums1.length; i++) {
            boolean flag = false;
            for (int j = 0; j < nums2.length && !flag; j++) {
                if (nums2[j] != nums1[i]) continue;
                for (int k = j + 1; k < nums2.length; k++) {
                    if (nums2[k] > nums2[j]) {
                        ans[i] = nums2[k];
                        break;
                    }
                }
                flag = true;
            }
        }
        return ans;
    }*/
}
