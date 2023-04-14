package com.nuaa.main.dp.bag_01;

public class Solution_494 {

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i : nums) sum += i;
        if (Math.abs(target) > sum) return 0; // 此时没有方案
        if ((target + sum) % 2 == 1) return 0; // 此时没有方案
        int bagSize = (target + sum) / 2;
        int[] dp = new int[bagSize + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++)
            for (int j = bagSize; j >= nums[i]; j--)
                dp[j] += dp[j - nums[i]];

        return dp[bagSize];
    }

    // 回溯法
    /*int count = 0;
    public int findTargetSumWays(int[] nums, int target) {
        backtracking(nums, 0, target, 0);
        return count;
    }

    public void backtracking(int[] nums, int startIndex, int target, int sum) {
        if (startIndex == nums.length) {
            if (sum == target) count++;
            return;
        }
        backtracking(nums, startIndex + 1, target, sum + nums[startIndex]);
        backtracking(nums, startIndex + 1, target, sum - nums[startIndex]);
    }*/

}
