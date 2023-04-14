package com.nuaa.main.dp.rob;

import com.nuaa.main.structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution_337 {

    /*public int rob(TreeNode root) {
        int[] res = help(root);
        return Math.max(res[0], res[1]);
    }

    public int[] help(TreeNode node) {
        if (node == null) return new int[]{0, 0};
        int[] left = help(node.left);
        int[] right = help(node.right);

        // 偷当前结点
        int val1 = node.val + left[0] + right[0];
        // 不偷当前结点
        int val2 = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{val2, val1};
    }*/


    // 递归 超时
    /*public int rob(TreeNode root) {
        if (root == null) return 0;
        int val1 = root.val;
        if (root.left != null)
            val1 += (rob(root.left.left) + rob(root.left.right));
        if (root.right != null)
            val1 += (rob(root.right.left) + rob(root.right.right));

        int val2 = rob(root.left) + rob(root.right);
        return Math.max(val1, val2);
    }*/

    public int rob(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;
        if (map.containsKey(root)) return map.get(root);
        // 偷父节点
        int val = root.val;
        if (root.left != null) val += rob(root.left.left) + rob(root.left.right);
        if (root.right != null) val += rob(root.right.left) + rob(root.right.right);
        int val2 = rob(root.left) + rob(root.right);
        map.put(root, Math.max(val, val2));
        return Math.max(val, val2);
    }


}
