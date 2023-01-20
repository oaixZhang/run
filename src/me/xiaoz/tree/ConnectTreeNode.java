package me.xiaoz.tree;

public class ConnectTreeNode {
    public Node connect(Node root) {
        if (root == null) return null;
        connectNeighbor(root.left, root.right);
        return root;
    }

    private void connectNeighbor(Node left, Node right) {
        if (left == null || right == null)
            return;
        left.next = right;
        connectNeighbor(left.left, left.right);
        connectNeighbor(left.right, right.left);
        connectNeighbor(right.left, right.right);
    }
}
