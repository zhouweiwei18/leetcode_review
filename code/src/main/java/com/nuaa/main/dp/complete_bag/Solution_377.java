package com.nuaa.main.dp.complete_bag;

public class Solution_377 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) dp[i] += dp[i - nums[j]];
            }
        }
        return dp[target];
    }

    // 回溯法 超时
    /*List<List<Integer>> ans = new ArrayList<>();

    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        backtracking(nums, target,  0, new ArrayList<>());
        return ans.size();
    }

    public void backtracking(int[] candidates, int target, int sum, List<Integer> path) {
        if (sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            if (sum + candidates[i] > target) break;
            path.add(candidates[i]);
            backtracking(candidates, target,  sum + candidates[i], path);
            path.remove(path.size() - 1);
        }
    }*/
}
