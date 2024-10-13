package Tree.BinarySearchTree;

import Tree.Node;

public class BST {

    public Boolean searchBST(Node treeNode, int target) {

        if (treeNode == null) {
            return false;
        }

        if (treeNode.val < target) {
            return searchBST(treeNode.right, target);
        } else if (treeNode.val > target) {
            return searchBST(treeNode.left, target);
        } else {
            return true;
        }

    }

    public Node insertBSTNode(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }

        if (root.val < val) {
            root.right = insertBSTNode(root.right, val);
        } else if (root.val > val) {
            root.left = insertBSTNode(root.left, val);
        }

        return root;
    }

    // 10
    // /
    // 9
    public Node deletNode(Node root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val < val) {
            root.right = deletNode(root.right, val);
        } else if (root.val > val) {
            root.left = deletNode(root.left, val);
        } else {
            // Case 1: Node to be deleted is a leaf node
            if (root.left == null && root.right == null) {
                return null;
            }
            // Case 2: Node to be deleted has only one child
            else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // Case 3: Node to be deleted has two children
            else {
                Node successor = findMin(root.right);
                root.val = successor.val;
                root.right = deletNode(root.right, successor.val);
            }
        }

        return root;
    }

    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        Node treeNode = new Node();
        // Node.printNodes(treeNode);
        BST bst = new BST();

        // search operation
        // int target = 1;
        // Boolean result = bst.searchBST(treeNode, target);
        // System.out.println("search result matched with target " + target + ":" +
        // result);

        // insert operation
        System.out.println("new insert operation node");
        bst.insertBSTNode(treeNode, 10);
        // bst.insertBSTNode(treeNode, 9);
        Node newNode = bst.insertBSTNode(treeNode, 9);
        Node.printNodes(newNode);

        // delete operation
        Node delete = bst.deletNode(treeNode, 10);

        Node.printNodes(delete);
    }
}
