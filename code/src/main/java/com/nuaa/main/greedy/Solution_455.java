package com.nuaa.main.greedy;

import java.util.Arrays;

public class Solution_455 {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int index = s.length - 1;
        for (int i = g.length - 1; i >= 0; i--) {
            if (index >= 0 && s[index] >= g[i]) {
                count++;
                index--;
            }
        }
        return count;
    }

    // 双层循环
    /*public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < g.length; j++) {
                if (g[j] == -1) continue;
                if (s[i] >= g[j] && g[j] != -1) {
                    count++;
                    g[j] = -1;
                }
            }
        }
        return count;
    }*/
}
