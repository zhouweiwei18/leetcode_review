package com.nuaa.main.dp.complete_bag;

public class Solution_70 {
    /*public int climbStairs(int n) {
        if (n <= 2) return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }*/

    // 完全背包解法
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= 2; j++) {
                if (i >= j) dp[i] += dp[i - j];
            }
        }
        return dp[n];
    }

}
