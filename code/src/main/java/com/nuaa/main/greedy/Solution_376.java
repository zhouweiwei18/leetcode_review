package com.nuaa.main.greedy;

public class Solution_376 {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n <= 1) return n;
        int result = 1;
        int preDiff = 0;
        int curDiff = 0;
        for (int i = 0; i < n - 1; i++) {
            curDiff = nums[i + 1] - nums[i];
            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
                result++;
                preDiff = curDiff;
            }
        }
        return result;
    }
}
