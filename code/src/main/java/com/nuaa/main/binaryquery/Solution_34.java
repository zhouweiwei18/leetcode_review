package com.nuaa.main.binaryquery;

public class Solution_34 {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        int ans = -1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (target == nums[mid]) {
                ans = mid;
                break;
            }
            if (target < nums[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }

        if (ans == -1) {
            return new int[]{-1, -1};
        } else {
            int left_ans = ans;
            int right_ans = ans;
            for (int i = ans; i < nums.length; i++) {
                if (nums[i] == target) right_ans = i;
                else break;
            }
            for (int i = ans; i >= 0; i--) {
                if (nums[i] == target) left_ans = i;
                else break;
            }
            return new int[]{left_ans, right_ans};
        }
    }
}
