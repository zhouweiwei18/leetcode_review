package com.nuaa.main.binarytree;

import com.nuaa.main.structure.TreeNode;

import java.util.*;

public class Solution_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root == null) return ans;
        queue.offer(root);
        int flag = 0; // 0:不需要reverse ; 1:需要进行reverse
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
            if (flag == 1) {
                Collections.reverse(list);
                flag = 0;
            } else {
                flag = 1;
            }
            ans.add(new ArrayList<>(list));
        }
        return ans;
    }
}
