import java.util.Map;

// Enum for three types of order
enum Order {
    IN_ORDER,
    PRE_ORDER,
    POST_ORDER
}

class Tree {
    public Node rootNode;

    /* @formatter:off

    Sample binary tree:
                          10
                        /    \
                      5       15
                     / \     /  \
                    3   7   12   18
                   /   / \   \   \
                  1   6  13   20
    */
    public Tree() {
        this.rootNode = new Node(10);
        this.rootNode.right = new Node(15);
        this.rootNode.left = new Node(5);

        this.rootNode.left.left = new Node(3);
        this.rootNode.left.right = new Node(7);

        this.rootNode.right.left = new Node(12);
        this.rootNode.right.right = new Node(18);

        this.rootNode.left.left.left = new Node(1);
        this.rootNode.left.right.left = new Node(6);

        this.rootNode.right.left.right = new Node(13);
        this.rootNode.right.right.right = new Node(20);
    }

    public Tree(int[] input) {

    }

    // Map with left and right properties
    public Tree(Map<String, ?> input) {

    }

    // Parentheses indicate level
    public Tree(String input) {

    }

    public void levelOrderTraverse() {
        TreeTraverser.levelOrder(this.rootNode);
    }

    public void breadthFirstTraverse() {
        TreeTraverser.breadthFirst(this.rootNode);
    }

    // IN ORDER
    public void depthFirstTraverse() {
        TreeTraverser.depthFirst(this.rootNode);
    }
    
    public void print(Order order) {
        switch (order) {
            case IN_ORDER:
                System.out.println("\nIn-order");
                TreePrinter.inOrder(this.rootNode);
                break;
            case PRE_ORDER:
                System.out.println("\nPre-order");
                TreePrinter.preOrder(this.rootNode);
                break;
            case POST_ORDER:
                System.out.println("\nPost-order");
                TreePrinter.postOrder(this.rootNode);
                break;
            default:
                System.out.println("\nInvalid order. Defaulting to in-order.");
                TreePrinter.inOrder(this.rootNode);
        }
    }

    public static void main() {
        Tree tree = new Tree();
        tree.print(Order.PRE_ORDER);
        tree.print(Order.IN_ORDER);
        tree.print(Order.POST_ORDER);
        tree.levelOrderTraverse();
        tree.breadthFirstTraverse();
    }
}
