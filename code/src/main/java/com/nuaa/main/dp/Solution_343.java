package com.nuaa.main.dp;

public class Solution_343 {

    public int integerBreak(int n) {
        // dp[i] 表示拆分i能获得的最大乘积
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++)
            for (int j = 1; j <= i - j; j++)
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), dp[i - j] * j));

        return dp[n];
    }
}
