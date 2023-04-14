package com.nuaa.main.binarytree;

import com.nuaa.main.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_285 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode pre = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && pre.val <= p.val && p.val < root.val)
                return root;
            else
                pre = root;

            root = root.right;
        }
        return null;
    }
}
