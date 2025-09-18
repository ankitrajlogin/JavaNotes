

/*
--------------------------------------------
🌳 Trees in Java 
--------------------------------------------

1. Introduction
    - A Tree is a non-linear data structure that represents a hierarchical relationship among elements.
    - Unlike arrays, linked lists, stacks, or queues (which are linear), a tree organizes data in levels, similar to a family tree.
    - The topmost node is called the root, and each node may have 0 or more child nodes.



2. Basic Terminology
    Here are important terms related to trees:
        
        1. Node
            A fundamental unit of a tree that stores data and links to child nodes.
            Example: In a binary tree, each node has at most 2 children.
        
        2. Root
            The topmost node of the tree.
            A tree has exactly one root.
        
        3. Parent
            A node that has one or more child nodes.
        
        4. Child
            A node that descends from a parent node.
        
        5. Leaf (or External Node)
            A node with no children.
        
        6. Internal Node
            A node that has at least one child.
        
        7. Edge
            The connection between two nodes (parent → child).
        
        8. Path
            A sequence of nodes and edges connecting a node to another.
        
        9. Height of Tree
            The longest path from root to a leaf.
        
        10. Depth of a Node
            The distance from the root to that node (number of edges).
        
        11. Subtree
            A smaller tree inside a tree, starting from any node.
        
        12. Degree of Node
            The number of children a node has.




3. Types of Trees
    - General Tree → No restriction on the number of children.
    - Binary Tree → Each node has at most 2 children (left & right).
    - Binary Search Tree (BST) → A binary tree where:
    - Left child < Parent < Right child.
    - AVL Tree → A self-balancing BST.
    - Heap Tree → A binary tree used for priority queues.
    - Trie → A tree-like structure for storing strings (prefix-based).



4. Tree Traversals
    Ways to visit all nodes:
        1. Depth-First Traversal (DFS)
            - Inorder (Left → Root → Right)
            - Preorder (Root → Left → Right)
            - Postorder (Left → Right → Root)
        2. Breadth-First Traversal (BFS)
            - Also known as Level Order Traversal (using Queue).

 */


public class L01_Tree_introduction {
    
}
