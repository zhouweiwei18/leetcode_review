package com.nuaa.main.greedy;

public class Solution_45 {
    public int jump(int[] nums) {
        int curDistance = 0;
        int nextDistance = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            nextDistance = Math.max(i + nums[i], nextDistance);
            if (i == curDistance) {
                // 判读当前下标是否是终点
                if (curDistance != nums.length - 1) {
                    ans++;
                    curDistance = nextDistance;
                    if (nextDistance >= nums.length - 1) return ans;
                } else
                    break;
            }
        }
        return ans;
    }
}
