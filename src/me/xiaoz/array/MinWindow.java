package me.xiaoz.array;

import java.util.HashMap;

public class MinWindow {
    public String minWindow(String s, String t) {
        if (s == null || t == null)
            return "";
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> target = new HashMap<>();
        int valid = 0;
        for (int i = 0; i < t.length(); i++) {
            target.put(t.charAt(i), target.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0, right = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;
        while (right < s.length()) {
            char add = s.charAt(right++);
            if (target.containsKey(add)) {
                int count = window.getOrDefault(add, 0);
                window.put(add, ++count);
                if (count == target.get(add))
                    valid++;
            }
            while (valid == target.size()) {
                if (right - left < len) {
                    len = right - left;
                    start = left;
                }
                char drop = s.charAt(left++);
                if (target.containsKey(drop)) {
                    int count = window.get(drop);
                    if (count == target.get(drop))
                        valid--;
                    window.put(drop, --count);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public static void main(String[] args) {
        System.out.println(new MinWindow().minWindow("ADOBECODEBANC", "ABC"));
    }
}
