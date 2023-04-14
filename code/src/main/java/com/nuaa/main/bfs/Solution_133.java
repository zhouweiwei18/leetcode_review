package com.nuaa.main.bfs;

import java.util.*;

public class Solution_133 {
    // Map<Node, Node> map = new HashMap<>();

//    public Node cloneGraph(Node node) {
//        if (node == null) return null;
//        if (map.containsKey(node)) return map.get(node);
//
//        // 创建结点
//        Node cloneNode = new Node(node.val, new ArrayList<>());
//        map.put(node, cloneNode);
//        // 再拷贝其邻居
//        for (Node neighbors : node.neighbors) {
//            cloneNode.neighbors.add(cloneGraph(neighbors));
//        }
//        return cloneNode;
//    }

    public Node cloneGraph(Node node) {

        if (node == null) return null;

        // 创建访问标记map
        Map<Node, Node> map = new HashMap<>();

        // 创建队列
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        map.put(node, new Node(node.val, new ArrayList<>()));

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node n = queue.poll();
                // 遍历其所有邻居
                for (Node neighbors : n.neighbors) {
                    if (!map.containsKey(neighbors)) {
                        map.put(neighbors, new Node(neighbors.val, new ArrayList<>()));
                        queue.add(neighbors);
                    }
                    map.get(n).neighbors.add(map.get(neighbors));
                }
            }
        }
        return map.get(node);
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
