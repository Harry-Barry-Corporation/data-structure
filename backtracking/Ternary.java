import java.util.ArrayList;
import java.util.List;

// Given a ternary tree (each node of the tree can have up to three children), find all the root-to-leaf paths.

class Ternary {

    public static class Node {

        public int val;
        public List<Node> children;

        public Node(int val) {
            this.val = val;
            this.children = new ArrayList<>();
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }

    public static List<String> ternaryTreePath(Node root) {
        return new ArrayList<String>();
    }

    public static void main(String[] args) {
        Node basic = new Node(1);
        basic.children.add(new Node(2));
        basic.children.add(new Node(4));
        basic.children.add(new Node(6));
        basic.children.get(0).children.add(new Node(3));

        ternaryTreePath(basic);
    }
}
