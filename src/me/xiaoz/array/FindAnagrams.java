package me.xiaoz.array;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class FindAnagrams {
    // p in s
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || p == null) {
            return null;
        }
        HashMap<Character, Integer> window, target;
        target = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            target.put(p.charAt(i), target.getOrDefault(p.charAt(i), 0) + 1);
        }
        window = new HashMap<>();
        int left = 0, right = 0;
        int valid = 0;
        List<Integer> res = new LinkedList<>();
        while (right < s.length()) {
            char add = s.charAt(right);
            right++;
            if (target.containsKey(add)) {
                int count = window.getOrDefault(add, 0);
                count++;
                window.put(add, count);
                if (count == target.get(add))
                    valid++;
            }

            while (right - left >= p.length()) {
                if (valid == target.size()) res.add(left);
                char drop = s.charAt(left);
                left++;
                if (target.containsKey(drop)) {
                    int cur = window.remove(drop);
                    if (cur == target.get(drop))
                        valid--;
                    window.put(drop, --cur);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new FindAnagrams().findAnagrams("abab", "ab"));
    }
}
