package me.xiaoz.classic;

public class Multiply {
    public String multiply(String num1, String num2) {
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num2.length() - 1; i >= 0; i--) {
            for (int j = num1.length() - 1; j >= 0; j--) {
                int temp = (num1.charAt(j) - '0') * (num2.charAt(i) - '0');
                temp += res[i + j + 1];
                res[i + j] += temp / 10;
                res[i + j + 1] = temp % 10;
            }
        }
        int index = 0;
        while (index < res.length && res[index] == 0)
            index++;
        StringBuilder builder = new StringBuilder();
        while (index < res.length) {
            builder.append(res[index++]);
        }
        return builder.length() == 0 ? "0" : builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Multiply().multiply("123", "456"));
    }
}
