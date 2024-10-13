package Tree.QuestionBank;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class RightView {

    private void rightViewDFS(TreeNode node, int level, List<Integer> result) {
        if (node == null) {
            return;
        }

        // If this is the first node we're visiting at this level
        if (level == result.size()) {
            result.add(node.val);
        }

        // Visit right child first, then left
        rightViewDFS(node.right, level + 1, result);
        rightViewDFS(node.left, level + 1, result);
    }

    public List<Integer> rightView(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        if (root == null) {
            return arr;
        }

        while (!q.isEmpty()) {

            int length = q.size();
            for (int i = 0; i < length; i++) {

                TreeNode p = q.poll();
                // Add the last node of each level to the result
                if (i == length - 1) {
                    arr.add(p.val);
                }
                if (p.left != null) {
                    q.add(p.left);
                }
                if (p.right != null) {
                    q.add(p.right);
                }
            }

        }

        return arr;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        RightView obj = new RightView();
        System.out.println(obj.rightView(root));

    }
}
