package me.xiaoz.classic;

import java.util.HashMap;

public class LongestSubString {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int left = 0, right = 0;
        int res = 0;
        HashMap<Character, Integer> window = new HashMap<>();
        while (right < s.length()) {
            char add = s.charAt(right++);
            int count = window.getOrDefault(add, 0);
            window.put(add, count+1);

            while (window.get(add) > 1) {
                char remove = s.charAt(left++);
                int removeCount = window.get(remove);
                window.put(remove, removeCount - 1);
            }
            res = Math.max(res, right - left);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubString().lengthOfLongestSubstring("abcabcbb"));
    }
}
