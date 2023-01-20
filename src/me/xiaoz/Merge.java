package me.xiaoz;

public class Merge {
    /**
     * 输入： [4,5,6,0,0,0],[1,2,3]
     * 输出： [1,2,3,4,5,6]
     * 说明： A数组为[4,5,6]，B数组为[1,2,3]，后台程序会预先将A扩容为[4,5,6,0,0,0]，
     * B还是为[1,2,3]，m=3，n=3，传入到函数merge里面，
     * 然后请同学完成merge函数，将B的数据合并A里面，最后后台程序输出A数组
     */
    public void merge(int A[], int m, int B[], int n) {
        if (A == null || B == null)
            return;
        int left = m - 1, right = n - 1;
        int index = A.length - 1;
        while (index >= 0) {
            if (left < 0) {
                A[index--] = B[right--];
            } else if (right < 0) {
                A[index--] = A[left--];
            } else if (A[left] > B[right]) {
                A[index--] = A[left--];
            } else {
                A[index--] = B[right--];
            }
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 4, 6, 0, 0};
        int[] B = {2, 9};
        new Merge().merge(A,3,B,2);
        for (int i : A) {
            System.out.println(i);
        }
    }
}
