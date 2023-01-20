package me.xiaoz.classic;

import java.util.Comparator;
import java.util.PriorityQueue;

public class NthSuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n + 1];
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int prime : primes) {
            queue.offer(new int[]{1, prime, 1});//product,prime,index
        }
        int p = 1;
        while (p <= n) {
            int[] poll = queue.poll();
            if (ugly[p - 1] != poll[0]) {
                ugly[p++] = poll[0];
            }
            poll[0] = ugly[poll[2]] * poll[1];
            poll[2]++;
            queue.offer(poll);
        }
        return ugly[n];

    }

    public static void main(String[] args) {
        System.out.println(new NthSuperUglyNumber().nthSuperUglyNumber(10, new int[]{2, 3, 5}));
    }
}
