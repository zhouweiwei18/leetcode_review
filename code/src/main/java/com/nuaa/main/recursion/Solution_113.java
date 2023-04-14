package com.nuaa.main.recursion;

import com.nuaa.main.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution_113 {
    //List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, new ArrayList<>());
        List<List<Integer>> list = new ArrayList<>();

        for (List<Integer> ll : ans) {
            if (compute(ll, targetSum)) list.add(new ArrayList<>(ll));
        }
        return list;
    }
    List<List<Integer>> ans = new ArrayList<>();
    public void dfs(TreeNode node, List<Integer> path) {
        if (node == null) return;
        // 记录结点
        path.add(node.val);
        if (node.left == null && node.right == null) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (node.left != null) dfs(node.left, path);
        if (node.right != null) dfs(node.right, path);

        path.remove(path.size()-1);
    }

    public boolean compute(List<Integer> list, int target) {
        int sum = 0;
        for (Integer i : list) {
            sum += i;
        }
        return sum == target;
    }
}
