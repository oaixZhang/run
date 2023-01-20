package me.xiaoz.array;

import me.xiaoz.list.ListNode;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != nums[left]) {
                nums[++left] = nums[right];
            }
            right++;
        }
        return left + 1;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode left = head, right = head;
        while (right.next != null) {
            if (right.val != left.val) {
                left.next = right;
                left = left.next;
            } else {
                left.next = null;
            }
            right = right.next;
        }
        return head;
    }

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0)
            return 0;
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != val)
                nums[left++] = nums[right];
            right++;
        }
        return left;
    }

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2)
            return;
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0)
                nums[left++] = nums[right];
            right++;
        }
        while (left < nums.length) {
            nums[left++] = 0;
        }

    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2)
            return s;
        int res = 0;
        String tem = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = find(s, i, i);
            String s2 = find(s, i, i + 1);
            if (s1.length() > res) {
                tem = s1;
                res = s1.length();
            }
            if (s2.length() > res) {
                tem = s2;
                res = s2.length();
            }
        }
        return tem;
    }

    public String find(String s, int left, int right) {
        while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    public static void main(String[] args) {
        new RemoveDuplicates().moveZeroes(new int[]{0, 0, 12, 5, 8, 9, 1});
        System.out.println(new RemoveDuplicates().longestPalindrome("adbcdai"));
    }
}
