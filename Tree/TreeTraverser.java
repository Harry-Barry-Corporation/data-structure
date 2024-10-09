import java.util.ArrayDeque;
import java.util.Queue;

public class TreeTraverser {
    protected static void levelOrder(Node node) {
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
    }
}