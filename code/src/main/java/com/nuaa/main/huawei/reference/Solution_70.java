package com.nuaa.main.huawei.reference;

public class Solution_70 {

    // 解法1： 常规动态规划
    /*public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }*/

    // 解法2: 完全背包解法 排列 先背包 后物品
    /*public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        int m = 2;
        dp[0] = 1;

        for (int i = 0; i <= n; i++)
            for (int j = 1; j <= m; j++)
                if (i >= j) dp[i] += dp[i - j];

        return dp[n];
    }*/

    // 解法3： 递归解法 超时
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
