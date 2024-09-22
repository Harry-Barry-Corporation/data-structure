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
            Node current = queue.poll();
            System.out.print(current.val + " ");

            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
    }

    public static void main(String[] args) {
        Node rNode = new Node();
        Node.printNodes(rNode);
        System.out.println("\nBFS Traversal:");
        bfsTraversal(rNode);
    }
}