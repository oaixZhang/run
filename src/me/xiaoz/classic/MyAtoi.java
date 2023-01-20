package me.xiaoz.classic;

import java.util.LinkedList;

public class MyAtoi {
    public int myAtoi(String input) {
        String s = input.trim();
        if (s.length() == 0) return 0;
        char sign = s.charAt(0);
        int i = 0;
        boolean negative = false;
        if (sign == '-') {
            i++;
            negative = true;
        } else if (sign == '+') {
            i++;
        }
        int start = i;
        while (i < s.length()) {
            int num = s.charAt(i) - '0';
            if (num < 0 || num > 9) break;
            i++;
        }
        String digital = s.substring(start, i);
        if (digital.length()==0) return 0;
        try {
            int res = Integer.parseInt(digital);
            return negative ? -res : res;
        } catch (NumberFormatException e) {
        }
        return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        System.out.println(new MyAtoi().myAtoi("words and 987"));
    }
}
