package me.xiaoz.backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NQueens {
    List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        res = new LinkedList<>();
        char[][] board = new char[n][n];
        for (char[] chars : board) {
            Arrays.fill(chars, '.');
        }
        backtrack(board, 0);
        return res;
    }

    private void backtrack(char[][] board, int row) {
        if (row == board.length) {
            res.add(generateRes(board));
            return;
        }
        for (int j = 0; j < board[row].length; j++) {
            if (!isValid(board, row, j)) {
                continue;
            }
            board[row][j] = 'Q';
            backtrack(board, row + 1);
            board[row][j] = '.';
        }
    }

    private boolean isValid(char[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q')
                return false;
        }
        int i = row - 1, j = col - 1;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q')
                return false;
            i--;
            j--;
        }
        i = row - 1;
        j = col + 1;
        while (i >= 0 && j < board.length) {
            if (board[i][j] == 'Q')
                return false;
            i--;
            j++;
        }
        return true;
    }

    private List<String> generateRes(char[][] board) {
        List<String> tmp = new LinkedList<>();
        for (char[] chars : board) {
            tmp.add(new String(chars));
        }
        return tmp;
    }

    public static void main(String[] args) {
        System.out.println(new NQueens().solveNQueens(4));
    }
}
