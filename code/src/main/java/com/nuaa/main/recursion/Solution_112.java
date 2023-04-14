package com.nuaa.main.recursion;

import com.nuaa.main.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution_112 {
    List<Integer> list = new ArrayList<>();

    public boolean hasPathSum(TreeNode root, int targetSum) {
        dfs(root, 0);
        for (Integer value : list) {
            if (value == targetSum) return true;
        }
        return false;
    }

    public void dfs(TreeNode node, int sum) {
        // 判断当前结点是否是叶子结点
        if (node == null) return;
        // 更新sum值
        sum = sum + node.val;
        if (node.left == null && node.right == null) {
            list.add(sum);
        }
        if (node.left != null) {
            dfs(node.left, sum);
        }
        if (node.right != null) {
            dfs(node.right, sum);
        }
    }

}
