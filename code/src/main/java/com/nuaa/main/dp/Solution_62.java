package com.nuaa.main.dp;

public class Solution_62 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) dp[i][0] = 1;

        for (int i = 0; i < n; i++) dp[0][i] = 1;
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        return dp[m - 1][n - 1];
    }


    // 回溯法超时
    /*int path = 0;
    int[][] directions = new int[][]{{0, 1}, {1, 0}};

    public int uniquePaths(int m, int n) {
        int[][] board = new int[m][n];
        backtracking(board, m, n, 0, 0);
        return path;
    }

    public void backtracking(int[][] board, int m, int n, int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] == 1) return;
        if (x == m - 1 && y == n - 1) {
            path++;
            return;
        }
        board[x][y] = 1;
        for (int i = 0; i < directions.length; i++) {

            int x1 = x + directions[i][0];
            int y1 = y + directions[i][1];
            backtracking(board, m, n, x1, y1);
        }
        board[x][y] = 0;
    }*/

}
