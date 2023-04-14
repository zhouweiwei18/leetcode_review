package com.nuaa.main.difference;

public class Solution_122 {

    public int maxProfit(int[] prices) {
        int[] diff = new int[prices.length - 1];
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            diff[i - 1] = prices[i] - prices[i - 1];
            if (diff[i - 1] > 0) res += diff[i - 1];
        }
        return res;
    }
}
