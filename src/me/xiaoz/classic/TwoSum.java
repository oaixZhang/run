package me.xiaoz.classic;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    int[] res;

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[0];
        HashMap<Integer, Integer> memo = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            memo.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (memo.containsKey(target - nums[i]) && memo.get(target - nums[i]) != i) {
                res = new int[]{i, memo.get(target - nums[i])};
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoSum().twoSum(new int[]{3, 2, 4}, 6)));
    }
}
