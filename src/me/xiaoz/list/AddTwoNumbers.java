package me.xiaoz.list;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return null;

        ListNode head = new ListNode(-1);
        ListNode dummy = head;
        int temp = 0;
        do {
            temp += (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
            head.next = new ListNode(temp % 10);
            head = head.next;
            temp = temp / 10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        } while (temp != 0 || l1 != null || l2 != null);
        return dummy.next;

    }
    //9,9,9,9
    //9,9,9,9,9,9,9
    //8,9,9,9,

    public static void main(String[] args) {
        System.out.println(new AddTwoNumbers().addTwoNumbers(new ListNode(9, new ListNode(9)), new ListNode(9, new ListNode(9))));
    }
}
