package com.nuaa.main.binarytree;

import com.nuaa.main.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_270 {
    public int closestValue(TreeNode root, double target) {
        Deque<TreeNode> stack = new ArrayDeque<>();

        double min = Double.MAX_VALUE;
        int ans = root.val;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            double abs = Math.abs(root.val - target);
            if (abs < min) {
                ans = root.val;
                min = abs;
            }

            root = root.right;
        }

        return ans;
    }
}
