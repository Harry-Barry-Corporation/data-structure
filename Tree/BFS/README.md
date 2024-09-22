# Breadth-First Search (BFS) for Trees

Breadth-First Search is a tree traversal algorithm that explores all the nodes of a tree level by level, visiting all the nodes at the current depth before moving to the nodes at the next depth level.

## Key Characteristics

- Explores nodes in order of their distance from the root
- Uses a queue data structure to keep track of nodes to visit
- Visits all children of a node before moving to the next level
- Optimal for level-order traversal

## Common Applications

1. Level-order traversal of a tree
2. Finding the shortest path in a tree
3. Serialization/Deserialization of a tree
4. Finding all nodes at a given depth

## Time and Space Complexity

- Time Complexity: O(n), where n is the number of nodes in the tree
- Space Complexity: O(w), where w is the maximum width of the tree

## Implementation

The implementation typically uses a queue to store nodes to be visited. The algorithm starts at the root, enqueues it, and then repeatedly dequeues a node, processes it, and enqueues its children until the queue is empty.

