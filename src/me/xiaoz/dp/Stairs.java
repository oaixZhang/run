package me.xiaoz.dp;

public class Stairs {
    int result;

    public int climbStairs(int n) {
        backTrack(n);
        return result;
    }

    public void backTrack(int n) {
        if (n == 1 || n == 0) {
            result++;
            return;
        }
        backTrack(n - 1);
        backTrack(n - 2);
    }

    public int climbStairsBp(int n) {
        if (n <= 2) {
            return n;
        }
        int[] bp = new int[n + 1];
        bp[1] = 1;
        bp[2] = 2;
        for (int i = 3; i < bp.length; i++) {
            bp[i] = bp[i - 1] + bp[i - 2];
        }
        return bp[n];
    }

    private int[] memo;

    public int climbStairsMemo(int n) {
        memo = new int[n + 1];
        return bp(n);
    }

    private int bp(int n) {
        if (n <= 2)
            return n;
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = bp(n - 1) + bp(n - 2);
        return memo[n];
    }


    public static void main(String[] args) {
        System.out.println(new Stairs().climbStairs(45));
        System.out.println(new Stairs().climbStairsBp(45));
        System.out.println(new Stairs().climbStairsMemo(45));
    }
}
