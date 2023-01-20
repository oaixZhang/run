package me.xiaoz.tree;

public class GetInorderNext {
    TreeLinkNode GetNext(TreeLinkNode node) {
        if (node == null) return null;
        if (node.right != null) {
            TreeLinkNode right = node.right;
            while (right.left != null) {
                right = right.left;
            }
            return right;
        }
        while (node.next != null) {
            if (node.next.left == node)
                return node.next;
            node = node.next;
        }
        return null;
    }
}
