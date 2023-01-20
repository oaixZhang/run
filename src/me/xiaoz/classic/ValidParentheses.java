package me.xiaoz.classic;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        boolean valid = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty() || getOpposite(c) != stack.pop()) {
                    valid = false;
                    break;
                }
            }
        }
        if (!stack.isEmpty()) valid = false;
        return valid;
    }

    private char getOpposite(char c) {
        if (c == ')') return '(';
        else if (c == ']') return '[';
        else return '{';
    }

    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("(){[]}{}"));
    }
}
