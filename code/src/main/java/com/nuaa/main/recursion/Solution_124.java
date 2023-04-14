package com.nuaa.main.recursion;

import com.nuaa.main.structure.TreeNode;

public class Solution_124 {
    int maxRes = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;

        return posterOrder(root);
    }

    // 返回节点的贡献值
    private int posterOrder(TreeNode root) {

        if (root == null)
            return 0;

        int left = Math.max(posterOrder(root.left), 0);
        int right = Math.max(posterOrder(root.right), 0);

        maxRes = Math.max(maxRes, root.val + left + right);

        return root.val + Math.max(left, right);
    }
}
