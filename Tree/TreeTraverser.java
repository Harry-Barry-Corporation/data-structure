import java.util.ArrayDeque;
import java.util.Queue;

public class TreeTraverser {
       /* @formatter:off

                          10
                        /    \
                      5       15
                     / \     /  \
                    3   7   12   18
                   /   / \   \   \
                  1   6  13   20
        */

    protected static void levelOrder(Node node) {

        System.out.println("\n\nLevel order traversal\n");

        if (node == null) {
            return;
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        int level = 0;

        while (!queue.isEmpty()) {
            System.out.println("\nLevel: " + level);

            int length = queue.size();

            for (int i = 0; i < length; i += 1) {
                Node current = queue.remove();

                System.out.print(current.val + " ");

                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }
            }

            level += 1;
        }

    }

    protected static void breadthFirst(Node node) {
        System.out.println("\n\nBreadth-first traversal\n");

        if (node == null) {
            return;
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node current = queue.remove();
            System.out.print(current.val + " ");

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    // IN ORDER
    protected static void depthFirst(Node node) {
        if (node == null) {
            return;
        }

        depthFirst(node.left);
        System.out.println(node.val + " ");
        depthFirst(node.right);
    }
}