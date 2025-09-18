


/**


What is an AVL Tree ?
   - An AVL Tree is a self-balancing binary search tree where the difference 
    between the heights of the left and right subtrees of any node (known as 
    the balance factor) is at most 1. This ensures that the tree remains 
    approximately balanced, which guarantees O(log n) time complexity for 
    search, insertion, and deletion operations.

1. Key Properties
    i.It follows all rules of a BST:
        - Left child < Parent
        - Right child > Parent

    ii. Balance Factor (BF):
        - For every node:
            BF=Height of Left Subtree−Height of Right Subtree
        
        -In AVL trees, the balance factor must always be -1, 0, or +1.
        -If it goes outside this range (like -2 or +2), rotations are performed to rebalance.

    iii. Height of AVL Tree is always O(log n).
        - This ensures faster searching, insertion, and deletion compared to normal BST.
    
2. Key Characteristics of an AVL Tree:
    - Each node stores a height value, which is used to calculate the balance factor.
    - Rotations (left, right, left-right, right-left) are performed to restore balance 
      whenever the balance factor of a node becomes greater than 1 or less than -1.
    - The tree is named after its inventors, Adelson-Velsky and Landis.
    
3. Advantages:
    - Ensures faster lookups, insertions, and deletions compared to unbalanced binary 
      search trees.
    
4. Use Cases:
    - Suitable for applications where frequent insertions and deletions occur, and 
      maintaining a balanced tree is critical for performance.

    - Real-life Uses
        - Databases (to keep indexes balanced)
        - File systems
        - Memory management
        - Routing tables in networks

 */




/*
-----------------------
Operations
-----------------------

    Insertion
        - Insert like a normal BST.
        - Check balance factor → if unbalanced, apply rotations.

    Deletion
        - Delete like a normal BST.
        - Re-check balance factor and perform rotations if required.

    Rotations (to restore balance):
        - Right Rotation (LL Rotation)
        - Left Rotation (RR Rotation)
        - Left-Right Rotation (LR Rotation)
        - Right-Left Rotation (RL Rotation)

    Time Complexities
        - Search → O(log n)
        - Insertion → O(log n)
        - Deletion → O(log n)
        (because height of AVL tree is always log n)
 */




public class L01_AVL_Tree {

    
}