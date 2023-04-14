package com.nuaa.main.recursion;

import com.nuaa.main.structure.TreeNode;

public class Solution_104 {

    int max = 0;

    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        max = Math.max(left, right) + 1;

        return max;
    }

}
