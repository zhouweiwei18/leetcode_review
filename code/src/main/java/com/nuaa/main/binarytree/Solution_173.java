package com.nuaa.main.binarytree;

import com.nuaa.main.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_173 {
    private Deque<TreeNode> myStack = new ArrayDeque<>();
    private TreeNode node;

    public Solution_173(TreeNode root) {
        while (root != null) {
            myStack.push(root);
            root = root.left;
        }
    }

    public int next() {
        node = myStack.pop();
        node = node.right;
        while (node != null) {
            myStack.push(node);
            node = node.left;
        }
        return node.val;
    }

    public boolean hasNext() {
        return !myStack.isEmpty();
    }
}
