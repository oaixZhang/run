package me.xiaoz.classic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][0];
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        LinkedList<int[]> res = new LinkedList<>();
        res.add(intervals[0]);
        for (int[] cur : intervals) {
            int[] last = res.getLast();
            if (cur[0] <= last[1]) {
                last[1] = Math.max(cur[1], last[1]);
            } else {
                res.add(cur);
            }
        }
        return res.toArray(new int[0][0]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new MergeIntervals().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {12, 17}})));
    }
}
