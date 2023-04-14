package com.nuaa.main.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Solution_46 {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        backtrace(nums, visited, new ArrayList<>());
        return ans;
    }

    public void backtrace(int[] nums, boolean[] visited, List<Integer> path) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                path.add(nums[i]);
                visited[i] = true;
                //回溯
                backtrace(nums, visited, path);
                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }
    }
}
