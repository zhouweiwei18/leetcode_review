package com.nuaa.main.union_find;

import java.util.LinkedList;
import java.util.List;

public class Solution_685 {

    public int[] findRedundantDirectedConnection(int[][] edges) {
        // 首先计算每个节点的入度
        int[] inDegree = new int[edges.length + 1];

        for (int i = 0; i < edges.length; i++) {
            inDegree[edges[i][1]]++;
        }

        List<Integer> list = new LinkedList<>();

        // 判断是否有入度为2的即节点
        for (int i = edges.length - 1; i >= 0; i--) {
            if (inDegree[edges[i][1]] == 2) list.add(i);
        }

        // 处理入度为2的节点的边
        if (list.size() == 2) {
            if (isTreeAfterRemove(edges, list.get(0))) {
                return edges[list.get(0)];
            } else {
                return edges[list.get(1)];
            }
        }
        return removeEdge(edges);
    }

    private int[] removeEdge(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        UnionFind ufset = new UnionFind(parent);
        for (int i = 0; i < edges.length; i++) {
            if (ufset.find(edges[i][0]) == ufset.find(edges[i][1])) {
                return edges[i];
            } else {
                ufset.union(edges[i][0], edges[i][1]);
            }
        }
        return null;
    }

    private boolean isTreeAfterRemove(int[][] edges, Integer delete) {
        int[] parent = new int[edges.length + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        UnionFind ufset = new UnionFind(parent);
        for (int i = 0; i < edges.length; i++) {
            if (i == delete) continue;
            if (ufset.find(edges[i][0]) == ufset.find(edges[i][1])) {
                return false;
            } else
                ufset.union(edges[i][0], edges[i][1]);
        }

        return true;
    }


    public class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int[] parent) {

            this.parent = parent;
            this.rank = new int[parent.length];
            for (int i = 0; i < parent.length; i++) {
                rank[i] = 1;
            }
        }
        public int find(int x) {
            if (parent[x] == x) return x;
            return parent[x] = find(parent[x]);
        }
        public void union(int x, int y) {
            int xRoot = find(x), yRoot = find(y);
            if (xRoot != yRoot) {
                if (rank[xRoot] <= rank[yRoot])
                    parent[xRoot] = yRoot;
                else
                    parent[yRoot] = xRoot;
                if (rank[xRoot] == rank[yRoot]) rank[xRoot]++;
            }
        }
    }
}
