package com.nuaa.main.prefix_sum;

import com.nuaa.main.structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution_437 {

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0l, 1);
        return helper(root, prefixSumCount, targetSum, 0);
    }

    private int helper(TreeNode root, Map<Long, Integer> prefixSumCount, int targetSum, long curSum) {
        if (root == null) return 0;
        int res = 0;
        curSum += root.val;
        res += prefixSumCount.getOrDefault(curSum - targetSum, 0);
        prefixSumCount.put(curSum, prefixSumCount.getOrDefault(curSum, 0) + 1);
        res += helper(root.left, prefixSumCount, targetSum, curSum);
        res += helper(root.right, prefixSumCount, targetSum, curSum);
        prefixSumCount.put(curSum, prefixSumCount.get(curSum) - 1);
        return res;
    }
}
