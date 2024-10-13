package Tree.QuestionBank;

public class PreorderInOrderBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return buiTreeNode(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buiTreeNode(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        int rootIndex = 0;

        for (int i = inStart; i <= inEnd; i++) {
            if (root.val == inorder[i]) {
                rootIndex = i;
                break;
            }
        }

        int ledtSubTreeSize = rootIndex - inStart;
        root.left = buiTreeNode(preorder, preStart + 1, preStart + ledtSubTreeSize, inorder, inStart, rootIndex - 1);
        root.right = buiTreeNode(preorder, preStart + ledtSubTreeSize + 1, preEnd, inorder,
                rootIndex + 1, inEnd);

        return root;
    }

    public static void main(String[] args) {
        int[] preorder = { 3, 9, 20, 15, 7 };
        int[] inorder = { 9, 3, 15, 20, 7 };
        PreorderInOrderBinaryTree p = new PreorderInOrderBinaryTree();

        TreeNode root = p.buildTree(preorder, inorder);
        System.out.println(root.left.val);

    }
}
