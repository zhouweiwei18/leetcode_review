package com.nuaa.main.dp.bag_01;

public class Solution_416 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 11, 5};
        boolean flag = canPartition(arr);
        System.out.println(flag);
    }


    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (Integer i : nums) sum += i;
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int i = 0; i < nums.length; i++)
            for (int j = target; j >= nums[i]; j--)
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);

        if (dp[target] == target) return true;
        return false;
    }
}
