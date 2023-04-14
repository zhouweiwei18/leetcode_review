package com.nuaa.main.dp.subsequence;

public class Solution_647 {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        res++;
                        dp[i][j] = true;
                    } else {
                        if (dp[i + 1][j - 1]) {
                            res++;
                            dp[i][j] = true;
                        }
                    }
                }
            }
        }
        return res;
    }
}
