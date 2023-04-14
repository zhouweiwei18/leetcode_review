package com.nuaa.main.binarytree;

import com.nuaa.main.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Solution_297 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder ans = new StringBuilder();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (queue.size() != 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.removeFirst();
                ans.append(node == null ? "#" : node.val);
                ans.append(",");
                if (node == null) continue;
                queue.addLast(node.left);
                queue.addLast(node.right);
            }
        }
        return ans.substring(0, ans.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;
        String[] nodes = data.split(",");
        Deque<TreeNode> queue = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.addLast(root);

        for (int i = 1; i < nodes.length; ) {
            TreeNode parent = queue.removeFirst();
            if (nodes[i].equals("#")) {
                parent.left = null;
            } else {
                parent.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.addLast(parent.left);
            }
            if (nodes[i + 1].equals("#")) {
                parent.right = null;
            } else {
                parent.right = new TreeNode(Integer.parseInt(nodes[i + 1]));
                queue.addLast(parent.right);
            }
            i += 2;
        }
        return root;
    }
}
