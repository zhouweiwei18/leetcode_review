package com.nuaa.main.greedy;

import java.util.Arrays;

public class Solution_1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        while (k-- > 0) {
            Arrays.sort(nums);
            nums[0] = -nums[0];
        }
        int sum = 0;
        for (int i : nums) sum += i;
        return sum;
    }
}
