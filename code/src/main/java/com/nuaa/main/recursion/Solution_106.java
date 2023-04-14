package com.nuaa.main.recursion;

import com.nuaa.main.structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution_106 {

    // 创建map
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;

        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }

        return constructTree(postorder, inorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode constructTree(int[] postorder, int[] inorder, int postorder_left, int postorder_right, int inorder_left, int inorder_right) {

        // 判断是否合法
        if (postorder_left > postorder_right) return null;

        // 根节点的值
        int val = postorder[postorder_right];

        // 创建根节点
        TreeNode root = new TreeNode(val);

        // 获取中序遍历根节点的索引
        int index = map.get(val);

        // 计算左子树的结点个数
        int size = index - inorder_left;

        root.left = constructTree(postorder, inorder, postorder_left, postorder_left + size - 1, inorder_left, index - 1);
        root.right = constructTree(postorder, inorder, postorder_left + size, postorder_right - 1, index + 1, inorder_right);

        return root;
    }
}
