package com.nuaa.main.backtracking;

public class Solution_44 {

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[m][n] = true;

        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (i == m && j == n) continue;
                boolean first_match = (i < s.length() && j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?' || p.charAt(j) == '*'));
                if (j < p.length() && p.charAt(j) == '*') {
                    dp[i][j] = dp[i][j + 1] || first_match && dp[i + 1][j];
                } else {
                    dp[i][j] = first_match && dp[i + 1][j + 1];
                }
            }

        }
        return dp[0][0];
    }
}
