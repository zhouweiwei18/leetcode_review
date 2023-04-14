package com.nuaa.main.binarytree;

import com.nuaa.main.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution_272 {
    ArrayList<Integer> list = new ArrayList<>();
    ArrayList<Integer> ans = new ArrayList<>();

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        int val = closestValue(root, target);
        ans.add(val);
        int index = list.indexOf(val);
        int left = index - 1;
        int right = index + 1;
        while (left >= 0 && right <= list.size() - 1 && ans.size() < k) {
            int left_value = list.get(left);
            int right_value = list.get(right);
            double left_abs = Math.abs(left_value - target);
            double right_abs = Math.abs(right_value - target);
            if (left_abs < right_abs) {
                ans.add(left_value);
                left = left - 1;
            } else {
                ans.add(right_value);
                right = right + 1;
            }
        }
        while (left < 0 && right <= list.size() - 1 && ans.size() < k) {
            ans.add(list.get(right));
            right = right + 1;
        }
        while (left >= 0 && right > list.size() - 1 && ans.size() < k) {
            ans.add(list.get(left));
            left = left - 1;
        }

        return ans;
    }

    public int closestValue(TreeNode root, double target) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        double min = Double.MAX_VALUE;
        int ans = root.val;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            list.add(root.val);
            double abs = Math.abs(root.val - target);
            if (abs < min) {
                ans = root.val;
                min = abs;
            }

            root = root.right;
        }

        return ans;
    }
}
