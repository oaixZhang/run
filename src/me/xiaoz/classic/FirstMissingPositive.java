package me.xiaoz.classic;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] <= 0) nums[i] = length + 1;
        }
        for (int i = 0; i < length; i++) {
            int num = Math.abs(nums[i]) - 1;
            if (num < length) {
                nums[num] = -Math.abs(nums[num]);
            }
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return length + 1;
    }

    public static void main(String[] args) {
        System.out.println(new FirstMissingPositive().firstMissingPositive(new int[]{3, 6, 5, 4}));
    }
}
