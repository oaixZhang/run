package me.xiaoz.array;

import java.util.HashMap;

public class CheckInclusion {
    //s2 include s1
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        HashMap<Character, Integer> window, target;
        target = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            target.put(s1.charAt(i), target.getOrDefault(s1.charAt(i), 0) + 1);
        }
        window = new HashMap<>();
        int left = 0, right = 0;
        int valid = 0;
        while (right < s2.length()) {
            char add = s2.charAt(right++);
            if (target.containsKey(add)) {
                int count = window.getOrDefault(add, 0);
                window.put(add, ++count);
                if (target.get(add) == count)
                    valid++;
            }

            while (valid == target.size()) {
                if (right - left == s1.length())
                    return true;
                char drop = s2.charAt(left++);
                if (target.containsKey(drop)) {
                    int cur = window.remove(drop);
                    if (target.get(drop) == cur)
                        valid--;
                    window.put(drop, --cur);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new CheckInclusion().checkInclusion("ab", "eidboaoo"));
    }
}
