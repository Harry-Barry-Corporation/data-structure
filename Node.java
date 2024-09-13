class Node<T> {
    T val;
    Node<T> left;
    Node<T> right;

    Node(T val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    static void main() {
        Node<Integer> rootNode = new Node<>(10);
        rootNode.left = new Node<>(5);
        rootNode.right = new Node<>(15);
        
        rootNode.left.left = new Node<>(3);
        rootNode.left.right = new Node<>(7);
        
        rootNode.right.left = new Node<>(12);
        rootNode.right.right = new Node<>(18);
        
        rootNode.left.left.left = new Node<>(1);
        rootNode.left.right.left = new Node<>(6);
        
        rootNode.right.left.right = new Node<>(13);
        rootNode.right.right.right = new Node<>(20);

        /* Binary Tree Structure:
                10        
               /  \      
              5    15     
             / \  / \   
            3   7 12 18   
           /   /    \  \ 
          1   6     13  20
        */

    }
}
