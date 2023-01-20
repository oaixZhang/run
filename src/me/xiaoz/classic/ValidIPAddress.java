package me.xiaoz.classic;

public class ValidIPAddress {
    public static final String INVALID = "Neither";
    public static final String V4 = "IPv4";
    public static final String V6 = "IPv6";

    public String validIPAddress(String queryIP) {
        if (queryIP == null || queryIP.length() < 7) return INVALID;
        if (queryIP.contains(".")) {
            if (queryIP.startsWith(".") || queryIP.endsWith(".")) return INVALID;
            String[] split = queryIP.split("\\.");
            if (split.length != 4) return INVALID;
            for (String s : split) {
                int num = parseNum(s);
                if (num < 0 || num > 255) return INVALID;
            }
            return V4;
        } else if (queryIP.contains(":")) {
            if (queryIP.startsWith(":") || queryIP.endsWith(":")) return INVALID;
            String[] split = queryIP.split(":");
            if (split.length != 8) return INVALID;
            for (String s : split) {
                if (s.length() == 0 || s.length() > 4) return INVALID;
                for (char c : s.toCharArray()) {
                    c = Character.toLowerCase(c);
                    if (!Character.isDigit(c) && !(c >= 'a' && c <= 'f')) return INVALID;
                }
            }
            return V6;
        }
        return INVALID;
    }

    private int parseNum(String s) {
        if (s.length() == 0 || s.length() > 3 ||
                (s.charAt(0) == '0' && s.length() > 1)) return -1;
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            int tmp = s.charAt(i) - '0';
            if (tmp > 9 || tmp < 0) return -1;
            num = num * 10 + tmp;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(new ValidIPAddress().validIPAddress("1.1.1.1"));
    }
}
