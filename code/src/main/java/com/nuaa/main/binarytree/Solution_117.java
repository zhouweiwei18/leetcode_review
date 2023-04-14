package com.nuaa.main.binarytree;

import com.nuaa.main.structure.Node;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution_117 {
    public Node connect(Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        if (root == null) return null;
        queue.offer(root);
        root.next = null;
        while (queue.size() != 0) {
            int size = queue.size();
            Node pre = null;
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                if (pre == null) {
                    pre = node;
                } else {
                    pre.next = node;
                    pre = node;
                }
                if (i == size - 1) {
                    pre.next = null;
                }
            }
        }
        return root;
    }
}
