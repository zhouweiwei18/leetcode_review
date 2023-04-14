package com.nuaa.main.recursion;

import com.nuaa.main.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution_236 {

    List<TreeNode> path = new ArrayList<>();
    List<List<TreeNode>> res = new ArrayList<>();
    boolean flag = false;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        dfs(root, p);
        flag = false;
        path.clear();

        dfs(root, q);
        TreeNode ancestor = null;
        List<TreeNode> path_p = res.get(0);
        List<TreeNode> path_q = res.get(1);
        for (int i = 0; i < path_p.size() && i < path_q.size(); i++) {
            if (path_p.get(i) == path_q.get(i)) {
                ancestor = path_p.get(i);
            } else {
                break;
            }
        }
        return ancestor;
    }

    private void dfs(TreeNode root, TreeNode node) {
        if (root == null || flag)
            return;
        path.add(root);
        if (root == node) {
            flag = true;
            res.add(new ArrayList<>(path));
            return;
        }
        dfs(root.left, node);
        dfs(root.right, node);
        path.remove(path.size() - 1);
    }
}
