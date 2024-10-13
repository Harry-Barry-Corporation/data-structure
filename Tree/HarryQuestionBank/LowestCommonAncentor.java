package Tree.QuestionBank;

public class LowestCommonAncentor {

    public static TreeNode lowestCommonAncentor(TreeNode root, TreeNode p, TreeNode q) {

        if (root != null && root.val > p.val && root.val > q.val) {
            return lowestCommonAncentor(root.left, p, q);
        } else if (root != null && root.val < p.val && root.val < q.val) {
            return lowestCommonAncentor(root.right, p, q);
        } else {
            return root;
        }
    }

    // 3
    // / \
    // 5 1
    // / \ / \
    // 6 2 0 8
    // / \
    // 7 4

    public static void main(String[] args) {
        // Create a BST
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);

        // Choose two nodes for LCA
        TreeNode p = root.left.left; // Node with value 1
        TreeNode q = root.left.right.right; // Node with value 7
        TreeNode result = lowestCommonAncentor(root, p, q);
        System.out.println(result.val);
    }

    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        printTree(root.left);
        printTree(root.right);
    }
}
