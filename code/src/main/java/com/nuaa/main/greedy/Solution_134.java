package com.nuaa.main.greedy;

public class Solution_134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curSum = 0;
        int totalSum = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            if (curSum < 0) {
                start = i + 1;
                curSum = 0;
            }
        }
        if (totalSum < 0) return -1;
        return start;
    }


    //暴力 超时
    /*public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (gas[i] < cost[i]) continue;
            res = 0;
            for (int j = i; j <= i + n; j++) {
                if (res < 0) break;
                if (j != i && j % n == i) return i;
                res = gas[j % n] + res;
                res = res - cost[j % n];
            }
        }
        return -1;
    }*/
}
