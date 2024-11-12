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

public class Tree {

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

    // Level order traversal
    public Tree(Integer[] input) {
        if (input == null || input.length == 0) {
            this.rootNode = null;
            return;
        }

        System.out.println("\n\nInput array: " + Arrays.toString(input));

        this.rootNode = new Node(input[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(this.rootNode);

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
    public Tree(Map<String, Object> input) {
        if (input == null || !input.containsKey("value")) {
            this.rootNode = null;
            return;
        }

        this.rootNode = new Node((Integer) input.get("value"));
        buildTree(this.rootNode, input);
    }

    private void buildTree(Node currentNode, Map<String, Object> input) {
        if (input.containsKey("left")) {
            Object leftObj = input.get("left");

            if (leftObj instanceof Map) {
                Map<String, Object> leftInput = castToMap(leftObj);
                currentNode.left = new Node((Integer) leftInput.get("value"));
                buildTree(currentNode.left, leftInput);
            }
        }
        if (input.containsKey("right")) {
            Object rightObj = input.get("right");

            if (rightObj instanceof Map) {
                Map<String, Object> rightInput = castToMap(rightObj);
                currentNode.right = new Node((Integer) rightInput.get("value"));
                buildTree(currentNode.right, rightInput);
            }
        }
    }

    @SuppressWarnings("unchecked")
    private Map<String, Object> castToMap(Object obj) {
        return (Map<String, Object>) obj;
    }

    // Parentheses indicate level constructor
    // (1 (2 (4) (5)) (3 (6) (7)))
    // (1 (2 null (4)) (3 null (5)));

    public Tree(String input) {
        if (input == null || input.isEmpty()) {
            this.rootNode = null;
            return;
        }
        this.rootNode = buildTreeFromString(input);
    }

    private Node buildTreeFromString(String input) {
        input = input.trim();
        if (input.isEmpty() || input.equals("null")) {
            return null;
        }

        if (!input.startsWith("(")) {
            return null;
        }

        // Find the value between the opening parenthesis
        // and the first space or closing parenthesis
        int valueEnd = input.indexOf(' ');
        if (valueEnd == -1) {
            valueEnd = input.indexOf(')');
        }
        if (valueEnd == -1) {
            return null; // Invalid format
        }

        int value = Integer.parseInt(input.substring(1, valueEnd));
        Node node = new Node(value);

        // Only try to parse children
        // if there's more content after the value
        if (valueEnd < input.length() - 1) {
            int leftStart = valueEnd + 1;
            int leftEnd = findMatchingParenthesis(input, leftStart);
            node.left = buildTreeFromString(
                input.substring(leftStart, leftEnd)
            );

            int rightStart = leftEnd + 1;
            int rightEnd = findMatchingParenthesis(input, rightStart);
            node.right = buildTreeFromString(
                input.substring(rightStart, rightEnd)
            );
        }

        return node;
    }

    private int findMatchingParenthesis(String input, int start) {
        int count = 0;
        for (int i = start; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                count++;
            } else if (input.charAt(i) == ')') {
                count--;
            }
            if (count == 0) {
                return i + 1; // Return index after the closing parenthesis
            }
        }
        return input.length(); // In case of unmatched parentheses
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
            case INDENTED:
                System.out.println("\nIndented");
                TreePrinter.printIndented(this.rootNode);
                break;
            case VISUAL:
                System.out.println("\nVisual");
                TreePrinter.printVisual(this.rootNode);
                break;
            default:
                System.out.println("\nInvalid order. Defaulting to visual.");
                TreePrinter.printVisual(this.rootNode);
        }
    }

    public static void main() {
        Tree tree = new Tree();
        tree.print(Order.VISUAL);
        tree.print(Order.INDENTED);
        tree.print(Order.PRE_ORDER);
        tree.print(Order.IN_ORDER);
        tree.print(Order.POST_ORDER);
        tree.levelOrderTraverse();
        tree.breadthFirstTraverse();

        Integer[] levelOrderInput = { 5, 3, 8, 1, 4, 7, 9, 11 };
        Tree tree2 = new Tree(levelOrderInput);
        tree2.print(Order.VISUAL);

        Integer[] copied = { 3, 9, 20, null, null, 15, 7 };

        Tree tree3 = new Tree(copied);
        tree3.print(Order.VISUAL);

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

        Tree tree4 = new Tree(mapInput);
        tree4.print(Order.VISUAL);

        Tree tree5 = new Tree("(1 (2 (4) (5)) (3 (6) (7)))");
        Tree tree6 = new Tree("(1 (2 (3 (4) null) null) null)");
        Tree tree7 = new Tree("(1 (2 null (4)) (3 null (5)))");

        tree5.print(Order.VISUAL);
        tree6.print(Order.VISUAL);
        tree7.print(Order.VISUAL);
    }
}
