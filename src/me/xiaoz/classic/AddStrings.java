package me.xiaoz.classic;

public class AddStrings {
    public String addStrings(String num1, String num2) {
        int left = num1.length() - 1, right = num2.length() - 1;
        StringBuilder builder = new StringBuilder();
        int tmp = 0;
        while (left >= 0 || right >= 0 || tmp != 0) {
            int i = left >= 0 ? num1.charAt(left--) - '0' : 0;
            int j = right >= 0 ? num2.charAt(right--) - '0' : 0;
            tmp += (i + j);
            builder.append(tmp % 10);
            tmp /= 10;
        }
        builder.reverse();
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new AddStrings().addStrings("9", "11"));
    }
}
