# Binary Search

Binary search is an efficient algorithm for searching a sorted array by repeatedly dividing the search interval in half. It works by comparing the target value to the middle element of the array.

## Key Points

1. The array must be sorted for binary search to work correctly.
2. Time complexity: O(log n), where n is the number of elements in the array.
3. Space complexity: O(1) for iterative implementation, O(log n) for recursive implementation due to call stack.

## Time Complexity

| Operation | Time Complexity |
|-----------|-----------------|
| Search    | O(log n)        |
| Insertion | O(n)            |
| Deletion  | O(n)            |

Note: Insertion and deletion have O(n) time complexity because they require shifting elements to maintain the sorted order of the array.

## Calculating the Middle Index

A crucial step in binary search is calculating the middle index. The preferred method is:

```
This is preferred over `mid = (left + right) / 2;` for the following reasons:

1. Overflow Prevention: The primary reason for using `left + (right - left) / 2` instead of `(left + right) / 2` is to prevent integer overflow.

2. Large Values: When `left` and `right` are very large integers, their sum `(left + right)` might exceed the maximum value that can be stored in an `int` (2^31 - 1 in Java), causing an overflow.

