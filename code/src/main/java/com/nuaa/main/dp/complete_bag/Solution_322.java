package com.nuaa.main.dp.complete_bag;

import java.util.Arrays;

/*
输入：coins = [1, 2, 5], amount = 11
输出：3
解释：11 = 5 + 5 + 1
*/
public class Solution_322 {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < coins.length; i++)
            for (int j = coins[i]; j <= amount; j++)
                if (dp[j - coins[i]] != Integer.MAX_VALUE)
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }


    // 回溯超时
   /* int min = Integer.MAX_VALUE;
    boolean flag = false;
    List<Integer> path = new ArrayList<>();

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        backtracking(coins, amount, 0, 0);
        return !flag ? -1 : min;
    }

    public void backtracking(int[] coins, int amount, int sum, int startIndex) {
        if (sum == amount) {
            min = Math.min(path.size(), min);
            flag = true;
            return;
        }

        for (int i = startIndex; i < coins.length; i++) {
            if (sum + coins[i] > amount) break;
            path.add(coins[i]);
            backtracking(coins, amount, sum + coins[i], i);
            path.remove(path.size() - 1);
        }
    }*/
}
