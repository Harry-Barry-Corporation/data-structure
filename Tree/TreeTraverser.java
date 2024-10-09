import java.util.ArrayDeque;
import java.util.Queue;

public class TreeTraverser {
    protected static void levelOrder(Node node) {
        /* @formatter:off

                          10
                        /    \
                      5       15
                     / \     /  \
                    3   7   12   18
                   /   / \   \   \
                  1   6  13   20
        */

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

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.levelOrderTraverse();
        tree.breadthFirstTraverse();
    }
}