package me.xiaoz.array;

import java.util.Stack;

public class Valid {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[')
                stack.push(c);
            else {
                if (!stack.isEmpty() && opposite(c) == stack.peek())
                    stack.pop();
                else
                    return false;
            }
        }
        return stack.isEmpty();
    }

    private char opposite(char c) {
        if (c == '}') return '{';
        if (c == ']') return '[';
        return '(';
    }

    public static void main(String[] args) {
        System.out.println(new Valid().isValid("{}([)"));
    }
}
