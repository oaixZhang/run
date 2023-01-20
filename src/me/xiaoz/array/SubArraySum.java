package me.xiaoz.array;

import java.util.HashMap;

public class SubArraySum {

    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;

        int[] preSum = new int[nums.length + 1];
        HashMap<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);

        int res = 0;
        for (int i = 1; i <= nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
            int need = preSum[i] - k;
            res += count.getOrDefault(need, 0);
            count.put(preSum[i], count.getOrDefault(preSum[i], 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new SubArraySum().subarraySum(new int[]{1, -1, 0}, 0));
    }
}
