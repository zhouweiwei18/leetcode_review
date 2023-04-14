package com.nuaa.main.greedy;

public class Solution_55 {

    // 用cover来覆盖终点即可
    public boolean canJump(int[] nums) {
        int cover = 0;
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(i + nums[i], cover);
            if (cover >= nums.length - 1) return true;
        }
        return false;
    }


    /*public boolean canJump(int[] nums) {
        boolean[] flag = new boolean[nums.length];
        flag[0] = true;
        for (int i = 0; i < nums.length; i++) {
            if (flag[i]) {
                int val = nums[i];
                if (i + val >= nums.length) return true;
                Arrays.fill(flag, i, i + val, true);
            }
        }
        return flag[nums.length - 1];
    }*/
}
