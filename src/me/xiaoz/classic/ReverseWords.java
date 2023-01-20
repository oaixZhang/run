package me.xiaoz.classic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseWords {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        int left = 0, right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left < right) {
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            left++;
            right--;
        }
        String trim = s.trim();
        List<String> splits = Arrays.asList(trim.split("\\s+"));
        Collections.reverse(splits);
        return String.join(" ",splits);
    }

    public static void main(String[] args) {
        System.out.println(new ReverseWords().reverseWords("a good   example"));
    }
}
