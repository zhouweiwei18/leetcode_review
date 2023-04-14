package com.nuaa.main.binarytree;

import com.nuaa.main.structure.TreeNode;

public class Solution_98 {
    // 中序遍历实现
//    public boolean isValidBST(TreeNode root) {
//        Deque<TreeNode> myStack = new ArrayDeque<>();
//        if (root == null) return true;
//
//        double value = -Double.MAX_VALUE;
//        while (root != null || !myStack.isEmpty()) {
//            while (root != null) {
//                myStack.push(root);
//                root = root.left;
//            }
//            root = myStack.pop();
//            if (root.val <= value) return false;
//            value = root.val;
//            root = root.right;
//        }
//        return true;
//    }

    // 递归实现
    double pre = -Double.MAX_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST(root.left)) return false;
        if (root.val <= pre) return false;
        pre = root.val;
        return isValidBST(root.right);
    }


}
