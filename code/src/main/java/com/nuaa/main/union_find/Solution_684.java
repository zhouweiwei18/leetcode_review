package com.nuaa.main.union_find;

public class Solution_684 {

    public int[] findRedundantConnection(int[][] edges) {
        int[] par = new int[edges.length + 1];
        for (int i = 1; i <= par.length; i++) {
            par[i] = i;
        }
        UnionFind union = new UnionFind(par);
        for (int i = 0; i < edges.length; i++) {
            if (union.find(edges[i][0]) == union.find(edges[i][1])) {
                return edges[i];
            } else {
                union.union(edges[i][0], edges[i][1]);
            }
        }
        return null;
    }

    class UnionFind {
        private int[] parent;
        private int[] rank;

        public UnionFind(int[] parent) {
            this.parent = parent;
            this.rank = new int[parent.length];
            for (int i = 0; i < parent.length; i++) {
                this.rank[i] = 1;
            }
        }

        public void union(int x, int y) {
            int xRoot = find(x), yRoot = find(y);
            if (xRoot != yRoot) {
                if (rank[yRoot] <= rank[xRoot]) parent[yRoot] = xRoot;
                else parent[xRoot] = parent[yRoot];

                if (rank[xRoot] == rank[yRoot]) rank[xRoot]++;
            }
        }

        public int find(int x) {
            if (parent[x] == x) return x;
            return parent[x] = find(parent[x]);
        }
    }
}
