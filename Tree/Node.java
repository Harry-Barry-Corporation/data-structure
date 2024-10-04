public class Node {
    public int val;
    public Node left;
    public Node right;

    public Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public static void printNodes(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");
        printNodes(root.left);
        printNodes(root.right);
    }

    public static void main(String[] args) {
        /*
         * Binary Tree Structure:
         * 10
         * / \
         * 5 15
         * / \ / \
         * 3 7 12 18
         * / / \ \
         * 1 6 13 20
         */

        // This is constructing a tree
        Node rootNode = new Node(10);
        rootNode.right = new Node(15);
        rootNode.left = new Node(5);

        rootNode.left.left = new Node(3);
        rootNode.left.right = new Node(7);

        rootNode.right.left = new Node(12);
        rootNode.right.right = new Node(18);

        rootNode.left.left.left = new Node(1);
        rootNode.left.right.left = new Node(6);

        rootNode.right.left.right = new Node(13);
        rootNode.right.right.right = new Node(20);

        Node.printNodes(rootNode);
    }
}
