package me.xiaoz.classic;

public class ConvertToTitle {
    public String convertToTitle(int columnNumber) {
        StringBuilder builder = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            builder.append((char) ('A' + columnNumber % 26));
            columnNumber /= 26;
        }
        builder.reverse();
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ConvertToTitle().convertToTitle(27));
    }
}
