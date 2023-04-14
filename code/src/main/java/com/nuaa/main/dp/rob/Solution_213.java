package com.nuaa.main.dp.rob;

import java.util.Arrays;

public class Solution_213 {

    public int rob(int[] nums) {
        if (nums.length <= 1) return nums.length == 0 ? 0 : nums[0];
        // 下面做一个分类
        // 不抢头 不抢尾
        int[] nums1 = Arrays.copyOfRange(nums, 1, nums.length - 1);
        // 抢头， 不抢尾
        int[] nums2 = Arrays.copyOfRange(nums, 0, nums.length - 1);
        // 不抢头， 抢尾
        int[] nums3 = Arrays.copyOfRange(nums, 1, nums.length);

        return Math.max(Math.max(helper(nums1), helper(nums2)), helper(nums3));
    }

    public int helper(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < nums.length; i++)
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        return dp[nums.length - 1];
    }
}
