package com.nuaa.main.union_find;

public class Solution_547 {

    public int findCircleNum(int[][] isConnected) {
        int[] parent = new int[isConnected.length];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        UnionFind unionFind = new UnionFind(parent);
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected.length; j++) {
                if (i == j) continue;
                if (isConnected[i][j] == 1) {
                    if (unionFind.find(i) != unionFind.find(j))
                        unionFind.union(i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == i) count++;
        }
        return count;
    }

    public class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int[] parent) {
            this.parent = parent;
            this.rank = new int[parent.length];
            for (int i = 0; i < parent.length; i++) {
                this.rank[i] = 1;
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
                else parent[yRoot] = xRoot;

                if (rank[xRoot] == rank[yRoot]) rank[xRoot]++;
            }
        }

    }
}
