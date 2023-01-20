package me.xiaoz.classic;

public class Roman2Int {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'I':
                    res += 1;
                    break;
                case 'V':
                    if (i - 1 >= 0 && s.charAt(i - 1) == 'I') {
                        res += 3;
                    } else
                        res += 5;
                    break;
                case 'X':
                    if (i - 1 >= 0 && s.charAt(i - 1) == 'I') {
                        res += 8;
                    } else
                        res += 10;
                    break;
                case 'L':
                    if (i - 1 >= 0 && s.charAt(i - 1) == 'X') {
                        res += 30;
                    } else
                        res += 50;
                    break;
                case 'C':
                    if (i - 1 >= 0 && s.charAt(i - 1) == 'X') {
                        res += 80;
                    } else
                        res += 100;
                    break;
                case 'D':
                    if (i - 1 >= 0 && s.charAt(i - 1) == 'C') {
                        res += 300;
                    } else
                        res += 500;
                    break;
                case 'M':
                    if (i - 1 >= 0 && s.charAt(i - 1) == 'C') {
                        res += 800;
                    } else
                        res += 1000;
                    break;
            }
        }
        return res;
    }

    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < symbols.length; i++) {
            int tmp = num / values[i];
            while (tmp-- > 0) {
                builder.append(symbols[i]);
            }
            num = num % values[i];
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Roman2Int().intToRoman(3));
    }
}
