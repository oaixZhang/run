package me.xiaoz.array;

import java.util.Arrays;

public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int left = 0, right = nums.length - 1;
        //left index
        int leftIndex = -1, rightIndex = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int tmp = nums[mid];
            if (tmp == target) {
                right = mid - 1;
                leftIndex = mid;
            } else if (tmp < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int tmp = nums[mid];
            if (tmp == target) {
                left = mid + 1;
                rightIndex = mid;
            } else if (tmp < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return new int[]{leftIndex, rightIndex};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SearchRange().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 3)));
    }
}
