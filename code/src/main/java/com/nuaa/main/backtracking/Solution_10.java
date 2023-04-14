package com.nuaa.main.backtracking;

public class Solution_10 {

    public boolean isMatch(String text, String pattern) {
        // 多一维的空间，因为求 dp[len - 1][j] 的时候需要知道 dp[len][j] 的情况，
        // 多一维的话，就可以把 对 dp[len - 1][j] 也写进循环了
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        // dp[len][len] 代表两个空串是否匹配了，"" 和 "" ，当然是 true 了。
        dp[text.length()][pattern.length()] = true;

        // 从 len 开始减少
        for (int i = text.length(); i >= 0; i--) {
            for (int j = pattern.length(); j >= 0; j--) {
                // dp[text.length()][pattern.length()] 已经进行了初始化
                if (i == text.length() && j == pattern.length()) continue;

                boolean first_match = (i < text.length() && j < pattern.length()
                        && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));
                if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2] || first_match && dp[i + 1][j];
                } else {
                    dp[i][j] = first_match && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }

//    方法二
//    public boolean isMatch(String s, String p) {
//        if (p.isEmpty()) return s.isEmpty();
//        boolean first_match = (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));
//        if (p.length() >= 2 && p.charAt(1) == '*')
//            return (isMatch(s, p.substring(2)) || (first_match && isMatch(s.substring(1), p)));
//        else
//            return first_match && isMatch(s.substring(1), p.substring(1));
//    }


}
