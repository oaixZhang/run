package me.xiaoz.list;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length,
                Comparator.comparingInt(node -> node.val));
        for (ListNode node : lists) {
            if (node == null)
                continue;
            queue.offer(node);
        }
        while (!queue.isEmpty()) {
            ListNode poll = queue.poll();
            head.next = poll;
            head = head.next;
            if (poll.next != null) {
                queue.offer(poll.next);
            }
        }
        return dummy.next;
    }
}
