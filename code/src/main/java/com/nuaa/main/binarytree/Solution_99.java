package com.nuaa.main.binarytree;

import com.nuaa.main.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_99 {
    // 6 | 3 4 5 | 2
    private TreeNode errorOne = null;
    private TreeNode errorTwo = null;

    public void recoverTree(TreeNode root) {
        // 首先给errorOne, errorTwo 赋值
        findInorder(root);

        // 交换
        int temp = errorOne.val;
        errorOne.val = errorTwo.val;
        errorTwo.val = temp;
    }

    private void findInorder(TreeNode root) {
        TreeNode pre = null;
        Deque<TreeNode> myStack = new ArrayDeque<>();
        while (root != null || !myStack.isEmpty()) {
            while (root != null) {
                myStack.push(root);
                root = root.left;
            }

            root = myStack.pop();

            if (pre != null && pre.val > root.val) {
                if (errorOne == null) {
                    errorOne = pre;
                    errorTwo = root;
                } else {
                    errorTwo = root;
                }
            }
            pre = root;
            root = root.right;
        }

    }

}
