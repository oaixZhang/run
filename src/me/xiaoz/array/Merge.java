package me.xiaoz.array;

public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2 == null || n == 0) return;
        int[] res = new int[m + n];
        int first = 0, second = 0;

        for (int i = 0; i < res.length; i++) {
            if (second >= n)
                res[i] = nums1[first++];
            else if (first >= m)
                res[i] = nums2[second++];
            else if (nums1[first] <= nums2[second])
                res[i] = nums1[first++];
            else
                res[i] = nums2[second++];
        }
        System.arraycopy(res, 0, nums1, 0, nums1.length);
    }

    public static void main(String[] args) {
        new Merge().merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }
}
