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

    public static void main(String[] args) {
        Node treeNode = new Node();
        Node.printNodes(treeNode);
        BST bst = new BST();
        int target = 1;
        Boolean result = bst.searchBST(treeNode, target);
        System.out.println("search result matched with target " + target + ":" + result);
    }
}
