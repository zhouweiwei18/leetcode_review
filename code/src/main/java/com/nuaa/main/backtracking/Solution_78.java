package com.nuaa.main.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Solution_78 {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        ans.add(new ArrayList<Integer>());
        backtracking(nums, 0, new ArrayList<>());
        return ans;
    }

    public void backtracking(int[] nums, int startIndex, List<Integer> path) {
        if (startIndex >= nums.length) return;
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            ans.add(new ArrayList<>(path));
            backtracking(nums, i + 1, path);
            path.remove(path.size() - 1);
        }
    }
}
