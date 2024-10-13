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

public class Diameter {
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

    public int maxLength = 0;

    public int DiameterPath(TreeNode root) {

        if (root == null) {
            return -1;
        }

        int leftmost = DiameterPath(root.left);
        int rightmost = DiameterPath(root.right);

        int l = leftmost + rightmost + 2;
        maxLength = Math.max(maxLength, l);

        return Math.max(leftmost, rightmost) + 1;
    }

    public int DiameterTravesal(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftmost = DiameterTravesal(root.left);
        int rightmost = DiameterTravesal(root.right);
        maxLength = Math.max(maxLength, leftmost + rightmost);

        System.out.println("node " + root.val + "     left " + leftmost + "right " + rightmost + "       maxlength   "
                + maxLength);
        return Math.max(leftmost, rightmost) + 1;

    }

    public static void main(String[] args) {
        Diameter tree = new Diameter();

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(5);
        System.out.println("Original tree:");
        printTree(root);
        // tree.DiameterPath(root);
        // System.out.println("Diameter of the tree is: " + tree.maxLength);
        tree.DiameterTravesal(root);

    }

}
