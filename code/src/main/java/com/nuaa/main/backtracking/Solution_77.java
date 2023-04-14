package com.nuaa.main.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Solution_77 {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrace(n, 1, k, new ArrayList<>());
        return list;
    }

    public void backtrace(int n, int startIndex, int k, List<Integer> path) {
        if (path.size() == k) {
            list.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backtrace(n, i + 1, k, path);
            path.remove(path.size() - 1);
        }
    }
}

