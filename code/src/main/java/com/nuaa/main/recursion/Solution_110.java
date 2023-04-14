package com.nuaa.main.recursion;

import com.nuaa.main.structure.TreeNode;

public class Solution_110 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);

        return left && right && (Math.abs(height(root.left) - height(root.right)) <= 1);
    }

    /*public int height(TreeNode node) {
        if(node == null) return 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(node);
        int depth = 0;
        while (queue.size() != 0) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
            }
        }
        return depth;
    }*/

    public int height(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return Math.max(height(node.left), height(node.right)) + 1;
        }
    }


}
