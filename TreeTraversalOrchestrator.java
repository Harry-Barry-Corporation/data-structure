public class TreeTraversalOrchestrator {
    public static void performTraversals(Node<Integer> rootNode) {
        DFS<Integer> dfs = new DFS<>();
        
        System.out.print("Inorder traversal: ");
        dfs.inorder(rootNode);
        System.out.println();
        
        System.out.print("Preorder traversal: ");
        dfs.preorder(rootNode);
        System.out.println();
        
        System.out.print("Postorder traversal: ");
        dfs.postorder(rootNode);
        System.out.println();
    }
}