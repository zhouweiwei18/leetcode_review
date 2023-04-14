package com.nuaa.main.binarytree;

import com.nuaa.main.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution_199 {
    public List<Integer> rightSideView(TreeNode root) {
        // 层次遍历，拿到最右边的值
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        queue.offer(root);
        while (queue.size() != 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == size - 1) ans.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return ans;
    }
}
