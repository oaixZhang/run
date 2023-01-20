package me.xiaoz.dp;

public class Fib {
    public int fib(int n) {
        if (n == 0 || n == 1)
            return n;
        int i_1 = 1, i_2 = 0;
        int current = i_1 + i_2;
        for (int i = 2; i <= n; i++) {
            current = i_1 + i_2;
            i_2 = i_1;
            i_1 = current;
        }
        return current;
    }
}
