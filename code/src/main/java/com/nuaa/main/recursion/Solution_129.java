package com.nuaa.main.recursion;

import com.nuaa.main.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution_129 {
    List<List<Integer>> list = new ArrayList<>();

    public int sumNumbers(TreeNode root) {
        dfs(root, new ArrayList<>());
        int ans = 0;
        for (List<Integer> ll : list) {
            ans += getNumber(ll);
        }
        return ans;
    }

    private int getNumber(List<Integer> ll) {
        StringBuilder sb = new StringBuilder("");
        boolean flag = false;
        for (int i = 0; i < ll.size(); i++) {
            if (flag || ll.get(i) != 0) {
                sb.append(ll.get(i));
                flag = true;
            }
        }
        int res = Integer.parseInt(sb.toString().length() == 0 ? "0" : sb.toString());
        return res;
    }

    private void dfs(TreeNode root, List<Integer> path) {
        if (root == null) return;
        path.add(root.val);
        // 根结点
        if (root.left == null && root.right == null) {
            list.add(new ArrayList<>(path));
        }
        dfs(root.left, path);
        dfs(root.right, path);
        path.remove(path.size() - 1);
    }
}
