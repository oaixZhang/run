package me.xiaoz.array;

import java.util.Arrays;
import java.util.Random;

public class Sort {


    public int[] sortArray(int[] nums) {
        shuffle(nums);
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void shuffle(int[] nums) {
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            int rand = random.nextInt(nums.length);
            swap(nums, rand, i);
        }
    }

    /**
     * quicksort
     */
    public void quickSort(int[] nums, int lo, int hi) {
        if (lo >= hi) return;
        int partition = partition(nums, lo, hi);
        quickSort(nums, lo, partition - 1);
        quickSort(nums, partition + 1, hi);
    }

    private int partition(int[] nums, int lo, int hi) {
        int pivot = nums[lo];
        int i = lo, j = hi;
        while (true) {
            while (i < hi && nums[i] <= pivot)
                i++;
            while (j > lo && nums[j] >= pivot)
                j--;
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, j, lo);
        return j;
    }

    /**
     * mergesort
     */
    int[] temp;

    public int[] mergeSort(int[] nums) {
        temp = new int[nums.length];
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private void sort(int[] nums, int start, int end) {
        if (start >= end) return;
        int mid = (start + end) / 2;
        sort(nums, start, mid);
        sort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    private void merge(int[] nums, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            temp[i] = nums[i];
        }
        int left = start;
        int right = mid + 1;
        for (int i = start; i <= end; i++) {
            if (left > mid) {
                nums[i] = temp[right++];
            } else if (right > end) {
                nums[i] = temp[left++];
            } else if (temp[left] <= temp[right]) {
                nums[i] = temp[left++];
            } else {
                nums[i] = temp[right++];
            }
        }
    }

    /**
     * heapsort
     */
    public int[] heapSort(int[] nums) {
        if (nums == null || nums.length < 2) return nums;
        buildHeap(nums);
        int i = nums.length - 1;
        while (i > 0) {
            swap(nums, 0, i);
            sink(nums, 0, i--);
        }
        return nums;
    }

    private void sink(int[] nums, int i, int end) {
        int left = i * 2 + 1;
        while (left < end) {
            int max = nums[left];
            if (left + 1 < end && nums[left + 1] > nums[left]) {
                max = nums[left + 1];
                left = left + 1;
            }
            if (nums[i] >= max) break;
            swap(nums, i, left);
            i = left;
            left = i * 2 + 1;
        }
    }

    private void buildHeap(int[] nums) {
        int i = nums.length / 2 - 1;
        while (i >= 0) {
            sink(nums, i, nums.length);
            i--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        Sort sort = new Sort();
        System.out.println(Arrays.toString(sort.sortArray(new int[]{5, 2, 3, 1})));
    }

}
