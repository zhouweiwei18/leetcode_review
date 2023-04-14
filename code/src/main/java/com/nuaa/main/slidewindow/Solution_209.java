package com.nuaa.main.slidewindow;

public class Solution_209 {

    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int sum = 0;
        int ans = nums.length + 1;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // 移动起始位置
            while (sum >= target) {
                ans = Math.min(ans, i - start + 1);
                sum -= nums[start];
                start++;
            }
        }
        return ans == nums.length + 1 ? 0 : ans;
    }
}
