package com.nuaa.main.prefix_sum;

public class Solution_560 {


    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int[] sum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) sum[i] = nums[i];
            if (i > 0) sum[i] = sum[i - 1] + nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (i == 0) {
                    if (sum[j] == k)
                        count++;
                    continue;
                }
                if ((sum[j] - sum[i - 1]) == k) count++;
            }
        }
        return count;
    }
}
