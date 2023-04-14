package com.nuaa.main.structure;

public class ConstructTree {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 5, 1, 2};
        TreeNode root = new TreeNode(arr[0]);
        construct(arr, root, 0);
        preOrder(root);
    }
    public static void preOrder(TreeNode node) {
        if (node == null) return;
        System.out.println(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }
    public static void construct(int[] array, TreeNode node, int index) {
        if (index >= array.length || node == null) return;
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        if (left < array.length)
            node.left = array[left] == -1 ? null : new TreeNode(array[left]);
        if (right < array.length)
            node.right = array[right] == -1 ? null : new TreeNode(array[right]);
        construct(array, node.left, left);
        construct(array, node.right, right);
    }
}
