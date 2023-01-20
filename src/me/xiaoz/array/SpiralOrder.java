package me.xiaoz.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null)
            return res;
        int up = 0, left = 0;
        int row = matrix.length;
        int column = matrix[0].length;
        int bottom = row - 1, right = column - 1;
        while (res.size() < row * column) {
            if (up <= bottom) {
                for (int i = left; i <= right; i++) {
                    res.add(matrix[up][i]);
                }
                up++;
            }
            if (left <= right) {
                for (int i = up; i <= bottom; i++) {
                    res.add(matrix[i][right]);
                }
                right--;
            }
            if (up <= bottom) {
                for (int i = right; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= up; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
        return res;
    }

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int num = 1;
        int up = 0, left = 0;
        int right = n - 1, bottom = n - 1;
        while (num <= n * n) {
            if (up <= bottom) {
                for (int i = left; i <= right; i++) {
                    res[up][i] = num++;
                }
                up++;
            }
            if (left <= right) {
                for (int i = up; i <= bottom; i++) {
                    res[i][right] = num++;
                }
                right--;
            }
            if (up <= bottom) {
                for (int i = right; i >= left; i--) {
                    res[bottom][i] = num++;
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= up; i--) {
                    res[i][left] = num++;
                }
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(new SpiralOrder().spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        System.out.println(Arrays.deepToString(new SpiralOrder().generateMatrix(3)));
    }
}
