package me.xiaoz.classic;

public class ReversePairs {
    int res;
    int[] helper;

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        helper = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return res;
    }

    private void mergeSort(int[] nums, int start, int end) {
        if (start >= end) return;
        int mid = start + (end - start) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    private void merge(int[] nums, int start, int mid, int end) {
        if (end + 1 - start >= 0) System.arraycopy(nums, start, helper, start, end + 1 - start);

        int left = start, right = mid + 1;
        for (int i = start; i <= end; i++) {
            if (left > mid) {
                nums[i] = helper[right++];
            } else if (right > end) {
                nums[i] = helper[left++];
            } else if (helper[left] > helper[right]) {
                res += (mid - left + 1);
                nums[i] = helper[right++];
            } else {
                nums[i] = helper[left++];
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(new ReversePairs().reversePairs(new int[]{7, 5, 6, 4}));
    }
}
