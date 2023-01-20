package me.xiaoz.backtrack;

import java.util.*;

public class OpenLock {
    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>();

        if (deadends != null) {
            visited.addAll(Arrays.asList(deadends));
        }

        if (visited.contains("0000")) return -1;
        visited.add("0000");

        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");

        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur == null) continue;
                if (target.equals(cur)) return step;

                for (int j = 0; j < cur.length(); j++) {
                    String plus = plusOne(cur, j);
                    if (!visited.contains(plus)) {
                        visited.add(plus);
                        queue.add(plus);
                    }
                    String minus = minusOne(cur, j);
                    if (!visited.contains(minus)) {
                        visited.add(minus);
                        queue.add(minus);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private String plusOne(String current, int i) {
        char[] chars = current.toCharArray();
        if (chars[i] == '9') {
            chars[i] = '0';
        } else {
            chars[i] += 1;
        }
        return new String(chars);
    }

    private String minusOne(String current, int i) {
        char[] chars = current.toCharArray();
        if (chars[i] == '0') {
            chars[i] = '9';
        } else {
            chars[i] -= 1;
        }
        return new String(chars);
    }


    public static void main(String[] args) {
        System.out.println(new OpenLock().openLock(new String[]{"0000"}, "0202"));
    }
}
