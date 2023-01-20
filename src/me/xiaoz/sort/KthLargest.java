package me.xiaoz.sort;

public class KthLargest {
    public int findKthLargest(int[] nums, int k) {
        int target = nums.length - k;
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int p = partition(nums, low, high);
            if (p > target) {
                high = p - 1;
            } else if (p < target) {
                low = p + 1;
            } else {
                return nums[p];
            }
        }
        return -1;

    }


    private int partition(int[] nums, int low, int high) {
        if (low>=high){
            return low;
        }
        int pivot = nums[low];
        int i = low, j = high + 1;
        while (true) {
            while (nums[++i] < pivot) {
                if (i == high)
                    break;
            }
            while (nums[--j] > pivot) {
                if (j == low)
                    break;
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, low, j);

        return j;

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
