package me.xiaoz.dp;

import java.util.Arrays;

public class MaxEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0)
            return 0;
        Arrays.sort(envelopes, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);

        int[] top = new int[envelopes.length];
        int piles = 0;
        for (int[] envelope : envelopes) {
            int num = envelope[1];
            int left = 0;
            int right = piles;
            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid] < num) {
                    left = mid + 1;
                } else if (top[mid] > num) {
                    right = mid;
                } else {
                    right = mid;
                }
            }
            if (left == piles) {
                piles++;
            }
            top[left] = num;

        }
        return piles;
    }
}
