package com.nuaa.main.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_39 {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, 0, new ArrayList<>());
        return ans;
    }

    public void backtracking(int[] candidates, int target, int startIndex, int sum, List<Integer> path) {
        if (sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (sum + candidates[i] > target) break;
            path.add(candidates[i]);
            backtracking(candidates, target, i, sum + candidates[i], path);
            path.remove(path.size() - 1);
        }
    }
}
