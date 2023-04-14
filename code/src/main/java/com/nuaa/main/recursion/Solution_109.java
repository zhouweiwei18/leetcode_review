package com.nuaa.main.recursion;

import com.nuaa.main.structure.ListNode;
import com.nuaa.main.structure.TreeNode;

public class Solution_109 {

    public TreeNode sortedListToBST(ListNode head) {

        return sortedListToBST(head, head);
    }

    private TreeNode sortedListToBST(ListNode head, ListNode end) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != end) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // slow 所指为中点


        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head, slow);
        root.right = sortedListToBST(slow.next, end);

        return root;
    }




    /*public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        // 遍历链表, 存入map和int[]
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int[] nums = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }

        return constructBST(nums);
    }

    private TreeNode constructBST(int[] nums) {
        if (nums.length == 0) return null;
        // 获取中点
        int mid = nums.length / 2;
        int val = nums[mid];
        // 得到根节点
        TreeNode root = new TreeNode(val);

        // 左子树
        int[] left = new int[mid];
        System.arraycopy(nums, 0, left, 0, left.length);
        int[] right = new int[nums.length - mid - 1];
        System.arraycopy(nums, mid + 1, right, 0, right.length);
        root.left = constructBST(left);
        root.right = constructBST(right);

        return root;
    }*/
}
