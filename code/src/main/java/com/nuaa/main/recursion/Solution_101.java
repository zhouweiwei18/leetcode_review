package com.nuaa.main.recursion;

import com.nuaa.main.structure.TreeNode;

public class Solution_101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSame(root.left, root.right);
    }

    public boolean isSame(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;
        if (node1.val != node2.val) {
            return false;
        } else {
            return isSame(node1.left, node2.right) && isSame(node1.right, node2.left);
        }
    }
}
