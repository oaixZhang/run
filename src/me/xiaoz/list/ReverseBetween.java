package me.xiaoz.list;

public class ReverseBetween {
    ListNode nextTmp;

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return null;
        ListNode pre = null, cur = head;
        for (int i = 1; i < left; i++) {
            pre = cur;
            cur = cur.next;
        }
        ListNode reversed = reverseN(cur, right - left);
        cur.next = nextTmp;
        if (pre != null) {
            pre.next = reversed;
            return head;
        } else {
            return reversed;
        }
    }

    private ListNode reverseN(ListNode cur, int i) {
        if (i == 0) {
            nextTmp = cur.next;
            return cur;
        }
        ListNode last = reverseN(cur.next, --i);
        cur.next.next = cur;
        return last;
    }

    /**
     * 1->2->3->4->5
     * 1->4->3->2->5
     */
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(new ReverseBetween().reverseBetween(node1, 2, 4));
    }
}
