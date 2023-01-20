package me.xiaoz.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class IpAddress {
    List<String> res;
    LinkedList<Integer> track;

    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) return res;
        track = new LinkedList<>();
        dfs(s, 0);
        return res;
    }

    private void dfs(String s, int start) {
        if (track.size() == 4) {
            if (start == s.length()) {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < track.size(); i++) {
                    if (i > 0) builder.append(".");
                    builder.append(track.get(i));
                }
                res.add(builder.toString());
            }
            return;
        }
        if (start >= s.length()) return;
        int ip = 0;
        if (s.charAt(start) == '0') {
            track.addLast(0);
            dfs(s, start + 1);
            track.removeLast();
        } else {
            for (int i = start; i < start + 3; i++) {
                if (i >= s.length()) return;
                ip = ip * 10 + (s.charAt(i) - '0');
                if (ip > 255 || ip < 0) continue;
                track.addLast(ip);
                dfs(s, i + 1);
                track.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new IpAddress().restoreIpAddresses("101023"));
    }
}
