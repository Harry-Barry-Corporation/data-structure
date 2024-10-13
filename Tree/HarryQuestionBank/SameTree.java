package Tree.QuestionBank;

public class SameTree {
    public int isSame(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return 1;
        }
        if (q == null || p == null) {
            return -1;
        }

        if (p.val != q.val) {
            return -1;
        }

        int leftmost = isSame(p.left, q.left);
        int rightmost = isSame(p.right, q.right);
        if (leftmost == -1 || rightmost == -1) {
            return -1;
        } else {
            return 1;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        int result = isSame(p, q);
        return result == -1 ? false : true;
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);
        SameTree tree = new SameTree();
        boolean result = tree.isSameTree(p, q);
        System.err.println(result);

    }
}