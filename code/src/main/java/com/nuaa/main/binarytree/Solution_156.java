package com.nuaa.main.binarytree;

import com.nuaa.main.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_156 {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) return null;
        TreeNode head = null;
        TreeNode cur = root;

        Deque<TreeNode> stack = new ArrayDeque<>();
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        head = stack.pop();
        cur = head;
        while (!stack.isEmpty()) {
            cur.right = stack.pop();
            cur.left = cur.right.right;
            cur = cur.right;
        }
        cur.left = null;
        cur.right = null;
        return head;
    }
}
