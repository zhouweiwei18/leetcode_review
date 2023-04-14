package com.nuaa.main.recursion;

import com.nuaa.main.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_111 {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int min = 0;

        while (queue.size() != 0) {
            min++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) return min;

                if (node.left != null) queue.offer(node.left);

                if (node.right != null) queue.offer(node.right);
            }
        }
        return min;
    }

}
