package com.nuaa.main.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution_212 {
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    Set<String> ans = new HashSet<>();
    boolean[][] visited;
    Trie trie = new Trie();
    public List<String> findWords(char[][] board, String[] words) {
        for (String word : words) {
            trie.insert(word);
        }
        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                backtracking(board, visited, i, j, "");
            }
        }
        return new ArrayList<>(ans);
    }


    public void backtracking(char[][] board, boolean[][] visited, int x, int y, String str) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y])
            return;
        str += board[x][y];
        if (!trie.startsWith(str)) return;
        if (trie.search(str)) ans.add(str);
        visited[x][y] = true;
        for (int i = 0; i < directions.length; i++) {
            int x1 = x + directions[i][0];
            int y1 = y + directions[i][1];
            backtracking(board, visited, x1, y1, str);
        }
        visited[x][y] = false;
    }

    class Trie {
        private Trie[] children;
        private boolean isEnd;
        public Trie() {
            children = new Trie[26];
            isEnd = false;
        }
        public void insert(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                int index = ch - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new Trie();
                }
                node = node.children[index];
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            Trie node = searchPrefix(word);
            return node != null && node.isEnd;
        }

        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }

        public Trie searchPrefix(String prefix) {
            Trie node = this;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);
                int index = ch - 'a';
                if (node.children[index] == null) {
                    return null;
                }
                node = node.children[index];
            }
            return node;

        }
    }

}
