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

public class BalancedTree {
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

    boolean isBalancedConfig = true;

    private int inner(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftmost = inner(root.left);
        if (leftmost == -1) {
            return -1;
        }
        int rightmost = inner(root.right);
        if (rightmost == -1) {
            return -1;
        }
        if (Math.abs(leftmost - rightmost) > 1) {
            return -1;
        }
        return Math.max(leftmost, rightmost) + 1;

    }

    public boolean isBalanced(TreeNode root) {
        int result = this.inner(root);

        return result == -1 ? false : true;
    }

    public static void main(String[] args) {
        BalancedTree tree = new BalancedTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        // root.right.left.left = new TreeNode(5);
        System.out.println("Original tree:");
        printTree(root);
        boolean result = tree.isBalanced(root);
        System.err.println(result);
    }

}
