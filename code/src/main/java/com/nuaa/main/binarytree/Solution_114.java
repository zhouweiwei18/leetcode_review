package com.nuaa.main.binarytree;

import com.nuaa.main.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution_114 {
    // List<>里面不一定放的是Integer, 有可能放的是树的节点
    public void flatten(TreeNode root) {
        // 先序遍历树
        Deque<TreeNode> myStack = new ArrayDeque<>();
        List<TreeNode> list = new ArrayList<>();
        while (root != null || !myStack.isEmpty()) {
            while (root != null) {
                list.add(root);
                myStack.push(root);
                root = root.left;
            }
            root = myStack.pop();
            root = root.right;
        }
        for (int i = 1; i < list.size(); i++) {
            TreeNode pre = list.get(i - 1);
            TreeNode curr = list.get(i);
            pre.left = null;
            pre.right = curr;
        }
    }
}
