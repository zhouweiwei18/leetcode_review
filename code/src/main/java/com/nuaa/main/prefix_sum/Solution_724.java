package com.nuaa.main.prefix_sum;

import java.util.Arrays;

public class Solution_724 {

    public int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        for (int i = 0; i < nums.length; i++) {
            if (2 * sum + nums[i] == sum) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }

}
