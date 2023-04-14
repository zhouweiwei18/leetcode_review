package com.nuaa.main.recursion;

import com.nuaa.main.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_222 {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int count = 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (queue.size() != 0) {
            int size = queue.size();
            count += size;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pop();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return count;
    }
}
