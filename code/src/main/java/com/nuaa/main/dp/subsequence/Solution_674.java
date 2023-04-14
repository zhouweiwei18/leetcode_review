package com.nuaa.main.dp.subsequence;

import java.util.Arrays;

public class Solution_674 {
    public int findLengthOfLCIS(int[] nums) {

        int n = nums.length;
        if (n == 0 || n == 1) return n;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++)
            if (nums[i] > nums[i - 1]) dp[i] = dp[i - 1] + 1;

        Arrays.sort(dp);
        return dp[n - 1];
    }
}
