package com.nuaa.main.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Solution_216 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k, n, 0, 1);
        return ans;
    }

    public void backtracking(int k, int n, int sum, int startIndex) {
        if (path.size() > k) return;
        if (sum == n && path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i <= 9; i++) {
            if (sum + i > n) break;
            path.add(i);
            backtracking(k, n, sum + i, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
