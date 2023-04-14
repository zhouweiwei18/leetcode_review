package com.nuaa.main.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_40 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        used = new boolean[candidates.length];
        backtracking(candidates, used, target, 0, 0);
        return ans;
    }

    public void backtracking(int[] candidates, boolean[] used, int target, int sum, int startIndex) {
        if (sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (sum + candidates[i] > target) break;
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) continue;
            path.add(candidates[i]);
            used[i] = true;
            backtracking(candidates, used, target, sum + candidates[i], i + 1);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
