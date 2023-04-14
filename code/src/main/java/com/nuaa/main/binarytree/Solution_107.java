package com.nuaa.main.binarytree;

import com.nuaa.main.structure.TreeNode;

import java.util.*;

public class Solution_107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root == null) return ans;
        queue.offer(root);
        while (queue.size() != 0) {
            int size = queue.size();
            // 创建list
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                list.add(root.val);
                if (root.left != null) queue.offer(root.left);
                if (root.right != null) queue.offer(root.right);
            }
            ans.add(new ArrayList<>(list));
        }
        Collections.reverse(ans);
        return ans;
    }
}
