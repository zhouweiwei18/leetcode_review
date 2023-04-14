package com.nuaa.main.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Solution_60 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public String getPermutation(int n, int k) {
        boolean[] used = new boolean[n + 1];
        backtracking(n, used, k);
        List<Integer> res = ans.get(ans.size() - 1);
        StringBuilder sb = new StringBuilder("");
        for (Integer i : res) {
            sb.append(i);
        }
        return sb.toString();
    }

    public void backtracking(int n, boolean[] used, int k) {
        if (ans.size() == k) return;

        if (path.size() == n) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!used[i]) {
                path.add(i);
                used[i] = true;
                backtracking(n, used, k);
                path.remove(path.size() - 1);
                used[i] = false;

            }
        }
    }
}

