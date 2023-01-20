package me.xiaoz.array;

import java.util.Arrays;

public class BinarySearch {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        int left = 0, right = nums.length;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target) {
                right = mid;
            } else
                left = mid + 1;
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        return new int[]{leftBound(nums, target), rightBound(nums, target)};
    }

    private int rightBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                left = mid + 1;
            }
        }
        if (right < 0 || nums[right] != target) return -1;
        return right;
    }

    private int leftBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                right = mid - 1;
            }
        }
        if (left >= nums.length || nums[left] != target) return -1;
        return left;
    }

    public static void main(String[] args) {
        System.out.println(new BinarySearch().search(new int[]{2, 3, 5, 7}, 1));
        System.out.println(Arrays.toString(new BinarySearch().searchRange(new int[]{2, 3, 5, 7}, 1)));
    }
}
