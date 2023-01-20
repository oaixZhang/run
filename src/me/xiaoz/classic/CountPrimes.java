package me.xiaoz.classic;

import java.util.Arrays;

public class CountPrimes {
    public int countPrimes(int n) {
        int count = 0;
        boolean[] candidates = new boolean[n];
        Arrays.fill(candidates, true);

        for (int i = 2; i * i < n; i++) {
            if (candidates[i]) {
                for (int j = i * i; j < n; j += i) {
                    candidates[j] = false;
                }
            }
        }

        for (int i = 2; i < n; i++) {
            if (candidates[i]) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new CountPrimes().countPrimes(120));
    }
}
