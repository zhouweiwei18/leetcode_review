package com.nuaa.main.bfs;

public class Solution_130 {
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    boolean[][] flag;

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        flag = new boolean[m][n];
        // 四个边界进行遍历，标记所有的 o
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && board[i][j] == 'O') {
                    dfs(m, n, board, flag, i, j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !flag[i][j])
                    board[i][j] = 'X';
            }
        }
    }


    public void dfs(int m, int n, char[][] board, boolean[][] flag, int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n || flag[x][y] || board[x][y] == 'X') return;
        flag[x][y] = true;
        for (int i = 0; i < directions.length; i++) {
            int x1 = x + directions[i][0];
            int y1 = y + directions[i][1];
            dfs(m, n, board, flag, x1, y1);
        }
    }
}
