package me.xiaoz.classic;

public class Calculator {
    int res;


    public int calculate(String s) {
        for (int i = 0; i < s.length(); i++) {


        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Calculator().calculate("- (3 + (4 + 5))"));
    }
}
