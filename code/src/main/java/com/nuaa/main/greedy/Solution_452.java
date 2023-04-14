package com.nuaa.main.greedy;

import java.util.Arrays;

public class Solution_452 {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int ans = 1;
        int end = points[0][1];
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] > end) {
                end = points[i][1];
                ans++;
            }
        }

        return ans;
    }
}
