import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

// Enum for three types of order
enum Order {
    IN_ORDER,
    PRE_ORDER,
    POST_ORDER,
    INDENTED,
    VISUAL,
}

class Node {

    public int val;
    public Node left;
    public Node right;

    public Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

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
    public Node() {
        this.val = 10;
        this.right = new Node(15);
        this.left = new Node(5);

        this.left.left = new Node(3);
        this.left.right = new Node(7);

        this.right.left = new Node(12);
        this.right.right = new Node(18);

        this.left.left.left = new Node(1);
        this.left.right.left = new Node(6);

        this.right.left.right = new Node(13);
        this.right.right.right = new Node(20);
    }

    // Level order traversal
    public Node(Integer[] input) {
        if (input == null || input.length == 0) {
            return;
        }

        System.out.println(
            "\n\nInput array: " + Arrays.toString(input)
        );

        this.val = input[0];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(this);

        for (int i = 1; i < input.length; i += 1) {
            Node current = queue.poll();
            if (current == null) continue;

            if (input[i] != null) {
                current.left = new Node(input[i]);
                queue.offer(current.left);
            }

            if (++i < input.length && input[i] != null) {
                current.right = new Node(input[i]);
                queue.offer(current.right);
            }
        }
    }

    // Nested map with left and right properties
    public Node(Map<String, Object> input) {
        if (input == null || !input.containsKey("value")) {
            return;
        }

        System.out.println("\n\nInput map: " + input.toString());

        this.val = (int) input.get("value");
        buildTree(this, input);
    }

    private void buildTree(
        Node currentNode,
        Map<String, Object> input
    ) {
        if (input.containsKey("left")) {
            Object leftObj = input.get("left");

            if (leftObj instanceof Map) {
                Map<String, Object> leftInput = castToMap(
                    leftObj
                );
                currentNode.left = new Node(
                    (Integer) leftInput.get("value")
                );
                buildTree(currentNode.left, leftInput);
            }
        }
        if (input.containsKey("right")) {
            Object rightObj = input.get("right");

            if (rightObj instanceof Map) {
                Map<String, Object> rightInput = castToMap(
                    rightObj
                );
                currentNode.right = new Node(
                    (Integer) rightInput.get("value")
                );
                buildTree(currentNode.right, rightInput);
            }
        }
    }

    @SuppressWarnings("unchecked")
    private Map<String, Object> castToMap(Object obj) {
        return (Map<String, Object>) obj;
    }

    public void levelOrderTraverse() {
        Traverser.levelOrder(this);
    }

    public void breadthFirstTraverse() {
        Traverser.breadthFirst(this);
    }

    // IN ORDER
    public void depthFirstTraverse() {
        Traverser.depthFirst(this);
    }

    public void print(Order order) {
        switch (order) {
            case IN_ORDER:
                System.out.println("\nIn-order");
                Printer.inOrder(this);
                break;
            case PRE_ORDER:
                System.out.println("\nPre-order");
                Printer.preOrder(this);
                break;
            case POST_ORDER:
                System.out.println("\nPost-order");
                Printer.postOrder(this);
                break;
            case INDENTED:
                System.out.println("\nIndented");
                Printer.printIndented(this);
                break;
            case VISUAL:
                System.out.println("\nVisual");
                Printer.printVisual(this);
                break;
            default:
                System.out.println(
                    "\nInvalid order. Defaulting to visual."
                );
                Printer.printVisual(this);
        }
    }

    public static void main(String[] args) {
        Node treeNode = new Node();
        treeNode.print(Order.VISUAL);
        treeNode.print(Order.INDENTED);
        treeNode.print(Order.PRE_ORDER);
        treeNode.print(Order.IN_ORDER);
        treeNode.print(Order.POST_ORDER);
        treeNode.levelOrderTraverse();
        treeNode.breadthFirstTraverse();

        Integer[] levelOrderInput = { 5, 3, 8, 1, 4, 7, 9, 11 };
        Node treeNode2 = new Node(levelOrderInput);
        treeNode2.print(Order.VISUAL);

        Integer[] levelOrderInputWithNulls = {
            3,
            9,
            20,
            null,
            null,
            15,
            7,
        };
        Node treeNode3 = new Node(levelOrderInputWithNulls);
        treeNode3.print(Order.VISUAL);

        Map<String, Object> mapInput = Map.of(
            "value",
            10,
            "left",
            Map.of(
                "value",
                5,
                "left",
                Map.of("value", 3),
                "right",
                Map.of("value", 7)
            ),
            "right",
            Map.of(
                "value",
                15,
                "left",
                Map.of("value", 12),
                "right",
                Map.of("value", 18)
            )
        );

        Node treeNode4 = new Node(mapInput);
        treeNode4.print(Order.VISUAL);
    }
}
