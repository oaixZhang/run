package me.xiaoz.classic;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return null;
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = palindrome(s, i, i);
            String s2 = palindrome(s, i, i + 1);
            res = s1.length() > res.length() ? s1 : res;
            res = s2.length() > res.length() ? s2 : res;
        }
        return res;
    }

    private String palindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("ababbac"));
    }
}
