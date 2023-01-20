package me.xiaoz.array;

public class Rotate {
    public void rotate(int[][] matrix) {
        if (matrix == null) return;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for (int[] ints : matrix) {
            reverse(ints);
        }
    }

    private void reverse(int[] ints) {
        int left = 0, right = ints.length - 1;
        int temp;
        while (left < right) {
            temp = ints[left];
            ints[left] = ints[right];
            ints[right] = temp;
            left++;
            right--;
        }
    }


    public static void main(String[] args) {
        new Rotate().rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }
}
