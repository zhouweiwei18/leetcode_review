package com.nuaa.main.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_90 {
    List<List<Integer>> ans = new ArrayList<>();

    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        ans.add(new ArrayList<Integer>());
        backtracking(nums, used, 0);
        return ans;
    }

    public void backtracking(int[] nums, boolean[] used, int startIndex) {
        if (startIndex >= nums.length) return;
        for (int i = startIndex; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            path.add(nums[i]);
            used[i] = true;
            ans.add(new ArrayList<>(path));
            backtracking(nums, used, i + 1);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
