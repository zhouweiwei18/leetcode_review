package com.nuaa.main.bfs;

import java.util.*;

public class Solution_310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }

        // degree记录每个结点的度数
        int[] degree = new int[n];
        // 每个结点的邻居
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            degree[a]++;
            degree[b]++;

            if (!map.containsKey(a)) map.put(a, new ArrayList<Integer>());
            if (!map.containsKey(b)) map.put(b, new ArrayList<Integer>());

            map.get(a).add(b);
            map.get(b).add(a);
        }

        Queue<Integer> leafNodes = new ArrayDeque<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 1) leafNodes.add(i);
        }

        while (!leafNodes.isEmpty()) {
            res.clear();
            int size = leafNodes.size();
            for (int i = 0; i < size; i++) {
                int node = leafNodes.poll();
                res.add(node);
                // 得到它所有的邻居
                List<Integer> nearNode = map.get(node);
                for (Integer near : nearNode) {
                    degree[near]--;
                    if (degree[near] == 1) {
                        leafNodes.add(near);
                    }
                }
            }
        }
        return res;
    }
}
