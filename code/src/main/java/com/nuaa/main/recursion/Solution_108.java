package com.nuaa.main.recursion;

import com.nuaa.main.structure.TreeNode;

public class Solution_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;

        // 首先获取最中间的值，为根结点
        int mid = nums.length / 2;

        // 创建根节点
        TreeNode root = new TreeNode(nums[mid]);

        int[] left = new int[mid];
        System.arraycopy(nums, 0, left, 0, left.length);

        int[] right = new int[nums.length - mid - 1];
        System.arraycopy(nums, mid + 1, right, 0, right.length);

        root.left = sortedArrayToBST(left);
        root.right = sortedArrayToBST(right);

        return root;
    }
}
