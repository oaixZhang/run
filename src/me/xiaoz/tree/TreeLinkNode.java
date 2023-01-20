package me.xiaoz.tree;

public class TreeLinkNode {
    int val;
    TreeLinkNode left;
    TreeLinkNode right;
    TreeLinkNode next;

    TreeLinkNode() {
    }

    TreeLinkNode(int val) {
        this.val = val;
    }

    TreeLinkNode(int val, TreeLinkNode left, TreeLinkNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
