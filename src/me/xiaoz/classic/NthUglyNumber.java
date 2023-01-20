package me.xiaoz.classic;

public class NthUglyNumber {
    //2,3,5
    int nthUglyNumber(int n) {
        int[] ugly = new int[n + 1];
        int[] candidates = {2, 3, 5};
        int[] products = {1, 1, 1};
        int[] pointers = {1, 1, 1};
        int min;
        int p = 1;
        while (p <= n) {
            min = products[0];
            for (int i = 1; i < products.length; i++) {
                if (products[i] < min) {
                    min = products[i];
                }
            }
            ugly[p++] = min;
            for (int i = 0; i < products.length; i++) {
                if (min == products[i]) {
                    products[i] = ugly[pointers[i]] * candidates[i];
                    pointers[i] += 1;
                }
            }
        }
        return ugly[n];
    }

    public static void main(String[] args) {
        System.out.println(new NthUglyNumber().nthUglyNumber(6));
    }
}
