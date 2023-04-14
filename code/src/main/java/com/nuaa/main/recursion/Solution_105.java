package com.nuaa.main.recursion;

import com.nuaa.main.structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution_105 {

    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 首先获取整个结点的个数，创建map
        int len = preorder.length;

        // 对每一个结点值hash映射
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        // 创建树
        return constructTree(preorder, inorder, 0, len - 1, 0, len - 1);
    }

    private TreeNode constructTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        // 判断是否合法
        if (preorder_left > preorder_right) return null;

        int val = preorder[preorder_left];

        // 创建根节点
        TreeNode root = new TreeNode(val);

        // 寻找中序遍历中的根节点位置
        int pos = map.get(val);

        // 计算左子树中的结点个数
        int n = pos - inorder_left;

        // 创建root的左子树
        root.left = constructTree(preorder, inorder, preorder_left + 1, preorder_left + n, inorder_left, pos - 1);
        root.right = constructTree(preorder, inorder, preorder_left + n + 1, preorder_right, pos + 1, inorder_right);

        return root;
    }

    /*public TreeNode buildTree(int[] preorder, int[] inorder) {

        // 判断
        if (preorder.length != inorder.length || preorder.length < 1) return null;

        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        int index = -1;
        // 在中序遍历结果中查询根节点
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                index = i;
                break;
            }

        }

        // 没有找到根节点
        if (index == -1) return null;

        // 创建根节点，分别创建左右子树
        TreeNode root = new TreeNode(preorder[0]);

        // 左子树的前序遍历结果
        int[] pre_left = new int[index];
        System.arraycopy(preorder, 1, pre_left, 0, index);

        //左子树的中序遍历结果
        int[] inorder_left = new int[pre_left.length];
        System.arraycopy(inorder, 0, inorder_left, 0, inorder_left.length);
        root.left = buildTree(pre_left, inorder_left);

        // 右子树的前序遍历结果
        int[] pre_right = new int[preorder.length - 1 - index];
        System.arraycopy(preorder, pre_left.length + 1, pre_right, 0, pre_right.length);

        // 右子树的中序遍历结果
        int[] inorder_right = new int[pre_right.length];
        System.arraycopy(inorder, index + 1, inorder_right, 0, inorder_right.length);
        root.right = buildTree(pre_right, inorder_right);

        return root;
    }*/

}
