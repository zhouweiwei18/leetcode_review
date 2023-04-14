package com.nuaa.main.huawei.reference;

public class Solution_169 {

    // 摩尔计数法
    public int majorityElement(int[] nums) {
        int ans = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == ans) {
                count++;
            } else if (--count == 0) {
                ans = nums[i];
                count = 1;
            }
        }
        return ans;
    }


    // 排序
    /*public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }*/
}
