package me.xiaoz.classic;

import java.util.HashMap;

public class MinWindow {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length())
            return "";
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> target = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            target.put(c, target.getOrDefault(c, 0) + 1);
        }

        int validCount = 0;
        int left = 0, right = 0;
        int len = Integer.MAX_VALUE;
        int start = 0;
        while (right < s.length()) {
            char add = s.charAt(right++);
            if (target.containsKey(add)) {
                int addCount = window.getOrDefault(add, 0);
                addCount++;
                if (target.get(add) == addCount)
                    validCount++;
                window.put(add, addCount);
            }

            while (validCount == target.size()) {
                if (right - left < len) {
                    len = right - left;
                    start = left;
                }

                char drop = s.charAt(left++);
                if (target.containsKey(drop)) {
                    int dropCount = window.get(drop);
                    if (target.get(drop) == dropCount)
                        validCount--;
                    dropCount--;
                    window.put(drop, dropCount);
                }
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public static void main(String[] args) {
        System.out.println(new MinWindow().minWindow("ADOBECODEBANC", "ABC"));
    }
}
