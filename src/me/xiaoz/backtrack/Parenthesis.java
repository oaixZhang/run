package me.xiaoz.backtrack;

import java.util.LinkedList;
import java.util.List;

public class Parenthesis {
    private StringBuilder track;
    private List<String> res = new LinkedList<>();
    private int right;
    private int left;

    public List<String> generateParenthesis(int n) {
        if (n == 0) return res;
        track = new StringBuilder();
        generate(n, track);
        return res;
    }

    private void generate(int n, StringBuilder track) {
        if (right > left || right > n || left > n)
            return;
        if (track.length() == n * 2){
            res.add(track.toString());
            return;
        }
        track.append('(');
        left++;
        generate(n, track);
        track.deleteCharAt(track.length() - 1);
        left--;

        track.append(')');
        right++;
        generate(n, track);
        track.deleteCharAt(track.length() - 1);
        right--;
    }

    public int minAddToMakeValid(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int res = 0;
        int need = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                need += 1;
            } else {
                if (need > 0) {
                    need--;
                } else {
                    res += 1;
                }
            }
        }
        return res + need;
    }

    public int minInsertions(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int res = 0;
        int need = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                need += 2;
                if (need % 2 != 0) {
                    res++;
                    need--;
                }
            } else {
                need--;
                if (need == -1) {
                    res++;
                    need = 1;
                }
            }
        }
        return res + need;
    }

    public static void main(String[] args) {
        System.out.println(new Parenthesis().generateParenthesis(3));
//        System.out.println(new Parenthesis().minInsertions(")((("));
    }
}
