package me.xiaoz.list;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        return reverse(head);
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode tail = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return tail;
    }

    public static void test() {
        throw new RuntimeException("运行时异常");
    }

    public static void wrapper() {
        System.out.println("before");
        test();
        System.out.println("after");
    }


    public static void main(String[] args) {
        try {
            wrapper();
        } catch (Exception e) {
            System.out.println("main exception caught");
            e.printStackTrace();
        }
    }
}
