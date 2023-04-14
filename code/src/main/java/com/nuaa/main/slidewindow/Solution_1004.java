package com.nuaa.main.slidewindow;

public class Solution_1004 {

    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int ans = 0;
        int number = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                ans = Math.max(ans, i - left + 1);
            } else {
                number++;
                if (number <= k) {
                    ans = Math.max(ans, i - left + 1);
                } else {
                    while (number > k) {
                        if (nums[left] == 0) number--;
                        left++;
                    }
                }
            }
        }

        return ans;
    }
}
