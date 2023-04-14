package com.nuaa.main.dp.bag_01;

public class Solution_474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int zeroNum = get_count(str)[0];
            int oneNum = get_count(str)[1];
            for (int j = m; j >= zeroNum; j--) {
                for (int k = n; k >= oneNum; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - zeroNum][k - oneNum] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public int[] get_count(String str) {
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') count1++;
            if (str.charAt(i) == '1') count2++;
        }
        return new int[]{count1, count2};
    }

}
