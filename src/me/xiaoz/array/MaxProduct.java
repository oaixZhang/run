package me.xiaoz.array;

public class MaxProduct {
    public int maxProduct(int[] nums) {
        int length = nums.length;
        int[] max = new int[length + 1];
        int[] min = new int[length + 1];
        max[0] = 1;
        min[0] = 1;

        for (int i = 1; i < max.length; i++) {
            int num = nums[i - 1];
            max[i] = Math.max(Math.max(max[i - 1] * num, min[i - 1] * num), num);
            min[i] = Math.min(Math.min(max[i - 1] * num, min[i - 1] * num), num);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < max.length; i++) {
            res = Math.max(res, max[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MaxProduct().maxProduct(new int[]{-1, -2, -9, -6}));
    }
}
