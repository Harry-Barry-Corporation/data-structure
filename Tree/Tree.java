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

    // Interpreted with level-order traversal
    // root = [1, 2, 3, 4, 5, 6, 7]
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
    
    public void print(Order order) {
        switch (order) {
            case IN_ORDER:
                TreePrinter.inOrder(this.rootNode);
                break;
            case PRE_ORDER:
                TreePrinter.preOrder(this.rootNode);
                break;
            case POST_ORDER:
                TreePrinter.postOrder(this.rootNode);
                break;
            default:
                System.out.println("Invalid order. Defaulting to in-order.");
                TreePrinter.inOrder(this.rootNode);
        }
    }
}
