package com.nuaa.main.dp.complete_bag;

import java.util.Arrays;

public class Solution_279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n);
        dp[0] = 0;

        for (int i = 1; i * i <= n; i++)
            for (int j = i * i; j <= n; j++)
                if (dp[j - i * i] != n)
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);

        return dp[n];
    }


}
