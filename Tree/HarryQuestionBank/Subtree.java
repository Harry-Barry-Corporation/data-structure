package Tree.HarryQuestionBank;

import java.util.ArrayList;
import java.util.List;

public class Subtree {

    public boolean isSubtree(TreeNode root, TreeNode subTree) {

        if (root == null && subTree == null) {
            return true;
        }

        if (root == null || subTree == null) {
            return false;
        }

        if (SameTree(root, subTree)) {
            return true;
        }

        return isSubtree(root.left, subTree) || isSubtree(root.right, subTree);

    }

    public boolean SameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        return SameTree(p.left, q.left) && SameTree(p.right, q.right);
    }

    private List<Integer> collectAndPrintDescendants(TreeNode node) {
        if (node == null) {
            return new ArrayList<>();
        }

        // Collect descendants from left and right subtrees
        List<Integer> leftDescendants = collectAndPrintDescendants(node.left);
        List<Integer> rightDescendants = collectAndPrintDescendants(node.right);

        // Create a list with the current node and all its descendants
        List<Integer> allDescendants = new ArrayList<>();
        allDescendants.add(node.val);
        allDescendants.addAll(leftDescendants);
        allDescendants.addAll(rightDescendants);

        // Print the current node with all its descendants
        System.out.println("Node " + node.val + " with descendants: " + allDescendants);

        return allDescendants;
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        p.left.left = new TreeNode(4);
        p.left.right = new TreeNode(5);
        p.left.left.left = new TreeNode(6);

        TreeNode q = new TreeNode(2);
        q.left = new TreeNode(4);
        q.right = new TreeNode(5);

        Subtree obj = new Subtree();
        System.out.println(obj.isSubtree(p, q));

    }
}
