# Depth-First Search (DFS) for Trees

Depth-First Search (DFS) is a fundamental graph traversal algorithm that can be applied to trees. When used on a tree, DFS explores as far as possible along each branch before backtracking.

## Key Characteristics:

1. Explores deep into the tree structure before exploring siblings.
2. Uses a stack (often implemented using recursion) to keep track of nodes.
3. Can be implemented in three main variations: pre-order, in-order, and post-order.

## DFS Variations for Trees:

1. Pre-order: Visit root, then left subtree, then right subtree.
2. In-order: Visit left subtree, then root, then right subtree.
3. Post-order: Visit left subtree, then right subtree, then root.

## Applications:

- Searching for a specific node or value in a tree.
- Generating a hierarchical structure of a tree.
- Solving maze problems or pathfinding.
- Topological sorting in directed acyclic graphs.

## Time and Space Complexity:

- Time Complexity: O(n), where n is the number of nodes in the tree.
- Space Complexity: O(h), where h is the height of the tree (due to the call stack).


## It is important to note that an inorder traversal will only print the nodes in a sorted order if the tree is a binary search tree.
