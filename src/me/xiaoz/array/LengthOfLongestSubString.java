package me.xiaoz.array;

import java.util.HashMap;

public class LengthOfLongestSubString {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {
            char add = s.charAt(right);
            right++;
            Integer count = window.getOrDefault(add, 0);
            window.put(add, count + 1);
            while (window.getOrDefault(add, 0) > 1) {
                char drop = s.charAt(left);
                left++;
                int remove = window.remove(drop);
                window.put(drop, remove - 1);
            }
            res = Math.max(res, right - left);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubString().lengthOfLongestSubstring("abcabcbb"));
    }
}
