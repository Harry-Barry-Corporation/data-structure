package Tree.QuestionBank;

public class isValidBST {

    public boolean isValidBST1(TreeNode root) {
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBSTHelper(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }

        return isValidBSTHelper(root.left, min, root.val) &&
                isValidBSTHelper(root.right, root.val, max);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        isValidBST v = new isValidBST();
        System.out.println(v.isValidBST1(root));
    }
}
