package com.nuaa.main.backtracking;

public class Solution_79 {
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    boolean[][] visited;
    boolean flag = false;

    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                backtracking(board, word, i, j, 0);
            }
        }
        return flag;
    }

    public void backtracking(char[][] board, String word, int x, int y, int index) {
        if (index >= word.length()) {
            flag = true;
            return;
        }
        if (flag || x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y] || board[x][y] != word.charAt(index))
            return;

        visited[x][y] = true;
        for (int i = 0; i < directions.length; i++) {
            int x1 = x + directions[i][0];
            int y1 = y + directions[i][1];
            backtracking(board, word, x1, y1, index + 1);
        }
        visited[x][y] = false;
    }
}
