package com.nuaa.main.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_52 {
    List<List<String>> ans = new ArrayList<>();

    public int solveNQueens(int n) {
        // 创建棋盘
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], '.');
        }
        backtracking(board, 0);
        return ans.size();
    }

    public void backtracking(char[][] board, int row) {
        if (row >= board.length) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                StringBuilder sb = new StringBuilder("");
                for (int j = 0; j < board[i].length; j++) {
                    sb.append(board[i][j]);
                }
                list.add(sb.toString());
            }
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int col = 0; col < board.length; col++) {
            // 判断board[row][col]能否填入皇后
            if (isValid(board, row, col)) {
                board[row][col] = 'Q';
                backtracking(board, row + 1);
                board[row][col] = '.';
            }
        }
    }

    public boolean isValid(char[][] board, int row, int col) {
        int n = board.length;
        for (int i = 0; i < row; ++i) { // 相当于剪枝
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // 检查 45度角是否有皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // 检查 135度角是否有皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
