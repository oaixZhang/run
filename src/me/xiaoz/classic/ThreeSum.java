package me.xiaoz.classic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0) return new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);

        int i = 0;
        while (i < nums.length) {
            int first = nums[i];
            List<List<Integer>> twoSumRes = twoSum(nums, i + 1, nums.length - 1, -first);
            for (List<Integer> list : twoSumRes) {
                if (list != null && list.size() == 2) {
                    list.add(first);
                    res.add(list);
                }
            }
            while (i < nums.length && nums[i] == first) i++;
        }

        return res;
    }

    public List<List<Integer>> twoSum(int[] nums, int start, int end, int target) {
        List<List<Integer>> res = new LinkedList<>();

        while (start < end) {
            int left = nums[start];
            int right = nums[end];
            if (left + right == target) {
                res.add(new ArrayList<>(Arrays.asList(left, right)));
                while (start < end && nums[start] == left) start++;
            } else if (left + right < target) {
                while (start < end && nums[start] == left) start++;
            } else {
                while (start < end && nums[end] == right) end--;
            }
        }
        return res;
    }
    private List<List<Integer>> nSum(int[] nums, int n, int start, int target) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (n < 2 || len < n)
            return res;
        if (n == 2) {
            int small = start, big = len - 1;
            while (small < big) {
                int left = nums[small], right = nums[big];
                int sum = left + right;
                if (sum == target) {
                    res.add(new ArrayList<Integer>(Arrays.asList(left, right)));
                    while (small < big && nums[small] == left)
                        small++;
                    while (small < big && nums[big] == right)
                        big--;
                } else if (sum > target) {
                    while (small < big && nums[big] == right)
                        big--;
                } else {
                    while (small < big && nums[small] == left)
                        small++;
                }
            }
        } else {
            int i = start;
            while (i < len) {
                int now = nums[i];
                List<List<Integer>> sub = nSum(nums, n - 1, i + 1, target - now);
                for (List<Integer> s : sub) {
                    s.add(now);
                    res.add(s);
                }
                while (i < len && nums[i] == now)
                    i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new ThreeSum().threeSum(IntStream.range(-5, 10).toArray()));
    }


}
