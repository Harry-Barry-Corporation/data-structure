package Tree.BFS;

import Tree.Node;
import java.util.ArrayDeque;
import java.util.Queue;

class BFS {
    public static void bfsTraversal(Node root) {
        if (root == null)
            return;

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            // Get the size of the current level
            int levelSize = queue.size();

            // Process all nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();
                System.out.print(current.val + " ");

                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            // Print new line after processing all nodes at the current level
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Node rNode = new Node();
        // Node.printNodes(rNode);
        System.out.println("\nBFS Traversal:");
        bfsTraversal(rNode);
    }
}