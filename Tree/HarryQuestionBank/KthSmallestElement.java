package Tree.QuestionBank;

import java.util.ArrayList;
import java.util.List;

/**
 * KthSmallestElement
 */
public class KthSmallestElement {
    int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, k, list);
        return result;
    }

    public void inorderTraversal(TreeNode root, int k, List<Integer> list) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left, k, list);
        list.add(root.val);

        if (list.size() == k) {
            result = root.val;
            return;
        }
        inorderTraversal(root.right, k, list);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.right = new TreeNode(5);
        KthSmallestElement k = new KthSmallestElement();

        System.out.println(k.kthSmallest(root, 4));
    }
}