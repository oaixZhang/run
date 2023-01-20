package me.xiaoz.classic;

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int row = 0, column = matrix[0].length - 1;
        while (row < matrix.length && column >= 0) {
            int cur = matrix[row][column];
            if (cur == target) {
                return true;
            } else if (cur > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }

    int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 别返回，锁定左侧边界
                right = mid - 1;
            }
        }
        // 最后要检查 left 越界的情况
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }
    public static void main(String[] args) {
//        System.out.println(new SearchMatrix().searchMatrix(new int[][]{{-5}}, -5));
        System.out.println(new SearchMatrix().left_bound(new int[]{2,3,3, 3, 4, 5}, 3));
    }
}
