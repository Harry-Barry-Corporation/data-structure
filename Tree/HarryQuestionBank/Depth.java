package Tree.QuestionBank;

import java.util.ArrayDeque;

import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Depth {
    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                System.out.print(current.val + " ");
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            System.out.println(); // New line after each level
        }
    }

    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        int length = 0;
        if (root == null)
            return root;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            length = length + 1;

            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }

        System.out.print("lwfnbrg" + length);
        return root;
    }

    public static int MaxLength = -1;

    public void preorder(TreeNode root, Integer length) {
        if (root == null)
            return;
        System.out.print(root.val + " ");
        length = length + 1;
        if (MaxLength < length) {
            MaxLength = length;
        }
        preorder(root.left, length);
        preorder(root.right, length);
    }

    public int depthTravesal(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftmost = depthTravesal(root.left);
        int rightmost = depthTravesal(root.right);
        System.out.println("node " + root.val + "     left " + leftmost + "right " + rightmost);
        return Math.max(leftmost, rightmost) + 1;

    }

    public static void main(String[] args) {
        Depth tree = new Depth();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        System.out.println("Original tree:");
        printTree(root);
        // TreeNode newRoot = tree.invertTree(root);
        // System.out.println("Inverted tree:");
        // printTree(newRoot);
        // int length = 0;
        // tree.preorder(root, length);
        // System.out.println("Depth " + tree.MaxLength);
        int depthLength = tree.depthTravesal(root);
        System.out.println("depth" + depthLength);

    }

}
