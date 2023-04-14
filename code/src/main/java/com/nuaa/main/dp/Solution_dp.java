package com.nuaa.main.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_dp {

    public static void main(String[] args) {
        int[] weight = new int[]{1, 3, 4};
        int[] value = new int[]{15, 20, 30};
        int[] nums = new int[]{2, 3, 2};
        List<Integer> new_weight = new ArrayList<>();
        List<Integer> new_value = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int len = nums[i];
            while (len > 0) {
                new_weight.add(weight[i]);
                new_value.add(value[i]);
                len--;
            }
        }

        int bagSize = 10;
        int[] dp = new int[bagSize + 1];
        for (int i = 0; i < new_weight.size(); i++)
            for (int j = bagSize; j >= new_weight.get(i); j--)
                dp[j] = Math.max(dp[j], dp[j - new_weight.get(i)] + new_value.get(i));

        System.out.println(dp[bagSize]);
    }

    public void testMultiPack1(){
        // 版本一：改变物品数量为01背包格式
        List<Integer> weight = new ArrayList<>(Arrays.asList(1, 3, 4));
        List<Integer> value = new ArrayList<>(Arrays.asList(15, 20, 30));
        List<Integer> nums = new ArrayList<>(Arrays.asList(2, 3, 2));
        int bagWeight = 10;

        for (int i = 0; i < nums.size(); i++) {
            while (nums.get(i) > 1) { // 把物品展开为i
                weight.add(weight.get(i));
                value.add(value.get(i));
                nums.set(i, nums.get(i) - 1);
            }
        }

        int[] dp = new int[bagWeight + 1];
        for(int i = 0; i < weight.size(); i++) { // 遍历物品
            for(int j = bagWeight; j >= weight.get(i); j--) { // 遍历背包容量
                dp[j] = Math.max(dp[j], dp[j - weight.get(i)] + value.get(i));
            }
            System.out.println(Arrays.toString(dp));
        }
    }

}
