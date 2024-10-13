package Tree.QuestionBank;

public class MaxPathSum {
    public int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        if (root == null)
            return 0;

        int left = maxPathSum(root.left);
        int right = maxPathSum(root.right);
        int maxLeft = Math.max(left, 0);
        int maxRight = Math.max(right, 0);

        this.max = Math.max(this.max, (root.val + maxLeft + maxRight));

        return root.val + Math.max(maxLeft, maxRight);

    }

    // 0
    // / \
    // 1 2
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        MaxPathSum m = new MaxPathSum();
        m.maxPathSum(root);
        System.out.println(m.max);
    }
}
