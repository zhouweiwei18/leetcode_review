package com.nuaa.main.backtracking;

public class Solution_37 {
    public void solveSudoku(char[][] board) {
        backtracking(board);
    }

    public boolean backtracking(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] != '.') continue;
                // 为该位置赋值
                for (char j = '1'; j <= '9'; j++) {
                    // 判读是否合法
                    if (isValid(board, row, col, j)) {
                        board[row][col] = j;
                        if (backtracking(board)) return true;
                        board[row][col] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    public boolean isValid(char[][] board, int row, int col, char ch) {
        // 校验行
        for (int j = 0; j < board.length; j++) {
            if (board[row][j] == ch) return false;
        }
        // 校验列
        for (int j = 0; j < board.length; j++) {
            if (board[j][col] == ch) return false;
        }

        // 校验9宫格
        int rowStart = (row / 3) * 3;
        int colStart = (col / 3) * 3;
        for (int i = rowStart; i < rowStart + 3; i++) {
            for (int j = colStart; j < colStart + 3; j++) {
                if (board[i][j] == ch) return false;
            }
        }
        return true;
    }
}
