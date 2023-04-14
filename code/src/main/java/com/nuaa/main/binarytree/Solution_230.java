package com.nuaa.main.binarytree;

import com.nuaa.main.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution_230 {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> myStack = new ArrayDeque<>();
        while (root != null || !myStack.isEmpty()) {
            while (root != null) {
                myStack.push(root);
                root = root.left;
            }
            root = myStack.pop();
            ans.add(root.val);
            root = root.right;
        }
        return ans.get(k - 1);
    }
}
