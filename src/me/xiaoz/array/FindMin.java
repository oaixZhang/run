package me.xiaoz.array;

public class FindMin {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        int p = nums[right];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int num = nums[mid];
            if (num > p) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println(new FindMin().findMin(new int[]{3, 2, 1}));
    }
}
