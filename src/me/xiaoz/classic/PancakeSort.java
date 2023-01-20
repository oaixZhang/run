package me.xiaoz.classic;

import java.util.LinkedList;
import java.util.List;

public class PancakeSort {
    LinkedList<Integer> res;

    public List<Integer> pancakeSort(int[] arr) {
        if (arr == null || arr.length == 0)
            return null;
        res = new LinkedList<>();
        sort(arr, arr.length - 1);
        return res;

    }

    private void sort(int[] arr, int index) {
        if (index <= 0) return;
        int max = arr[0];
        int maxIndex = 0;

        for (int i = 0; i <= index; i++) {
            if (arr[i] > max) {
                maxIndex = i;
                max = arr[i];
            }
        }
        reverse(arr, maxIndex);
        res.add(maxIndex + 1);
        reverse(arr, index);
        res.add(index + 1);
        sort(arr, index - 1);
    }

    private void reverse(int[] arr, int maxIndex) {
        int left = 0, right = maxIndex;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        System.out.println(new PancakeSort().pancakeSort(new int[]{3, 2, 4, 1}));
    }
}
