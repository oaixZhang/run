package me.xiaoz.list;

public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode tmp = head;
        int length = 0;
        while (tmp != null) {
            length++;
            tmp = tmp.next;
        }
        for (int i = 1; i < length; i <<= 1) {
            ListNode pre = dummy;
            while (pre.next != null) {
                ListNode left = pre.next;
                ListNode leftEnd = left;
                for (int j = 1; j < i && leftEnd.next != null; j++) {
                    leftEnd = leftEnd.next;
                }
                ListNode right = leftEnd.next;
                leftEnd.next = null;

                ListNode rightEnd = right;
                for (int j = 1; j < i && rightEnd != null; j++) {
                    rightEnd = rightEnd.next;
                }

                ListNode next = null;
                if (rightEnd != null) {
                    next = rightEnd.next;
                    rightEnd.next = null;
                }

                pre.next = merge(left, right);
                while (pre.next != null) {
                    pre = pre.next;
                }
                pre.next = next;
            }
        }
        return dummy.next;
    }

    public ListNode sortList1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        return merge(sortList(head), sortList(mid));
    }

    private ListNode merge(ListNode left, ListNode right) {
        if (left == null) return right;
        if (right == null) return left;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                p.next = left;
                left = left.next;
            } else {
                p.next = right;
                right = right.next;
            }
            p = p.next;
        }
        p.next = left == null ? right : left;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node2.next = node1;
        node1.next = node3;
        node3.next = node5;
        node5.next = node4;
        ListNode node = new SortList().sortList(node2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

}
