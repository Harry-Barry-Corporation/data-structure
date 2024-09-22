class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    // Constructor to create the entire tree structure
    Node() {
        this(10);
        this.left = new Node(5);
        this.right = new Node(15);

        this.left.left = new Node(3);
        this.left.right = new Node(7);

        this.right.left = new Node(12);
        this.right.right = new Node(18);

        this.left.left.left = new Node(1);
        this.left.right.left = new Node(6);

        this.right.left.right = new Node(13);
        this.right.right.right = new Node(20);
    }

    static void printNodes(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");
        printNodes(root.left);
        printNodes(root.right);
    }

    public static void main(String[] args) {
        Node rootNode = new Node(); // This will create the entire tree structure

        // maxlength()

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

        // Add this line to print the nodes
        Node.printNodes(rootNode);
    }
}
