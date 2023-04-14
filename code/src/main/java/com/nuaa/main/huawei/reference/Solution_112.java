package com.nuaa.main.huawei.reference;

import com.nuaa.main.structure.TreeNode;

public class Solution_112 {
    boolean flag = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        backtracking(root, root.val, targetSum);
        return flag;
    }

    public void backtracking(TreeNode node, int sum, int target) {
        if (node == null || flag) return;
        if (sum == target && node.left == null && node.right == null) {
            flag = true;
            return;
        }
        if (node.left != null) backtracking(node.left, node.left.val + sum, target);
        if (node.right != null) backtracking(node.right, node.right.val + sum, target);
    }
}
