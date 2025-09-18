
/* 
1. Definition
    - A binary tree is a hierarchical data structure where:
    - Each node has at most two children:
        -Left child
        -Right child

    - The topmost node is called the root.
    - A node with no children is called a leaf.



2. Types of Binary Trees
    - Full Binary Tree: Every node has 0 or 2 children.
    - Complete Binary Tree: All levels filled except possibly the last, filled from left to right.
    - Perfect Binary Tree: All internal nodes have 2 children, and all leaf nodes are at the same level.
    - Degenerate (Skewed) Tree: Each parent has only one child (like a linked list).
    - Binary Search Tree (BST): Left child < Parent < Right child.



3. Tree Traversals (DFS)
    - Traversal = visiting all nodes in a particular order.
    - Inorder (Left → Root → Right)
    - Preorder (Root → Left → Right)
    - Postorder (Left → Right → Root)

        1
       / \
      2   3
     / \
    4   5

Inorder: [4, 2, 5, 1, 3]
Preorder: [1, 2, 4, 5, 3]
Postorder: [4, 5, 2, 3, 1]

    Use of these traversal 
        - Inorder → Sorted order in BST.
        - Preorder → Copy / reconstruct tree.
        - Postorder → Delete tree / expression evaluation.



4. Time Compliexity 
    | Operation | Best / Average | Worst Case (Skewed Tree) |
    | --------- | -------------- | ------------------------ |
    | Search    | O(log n)       | O(n)                     |
    | Insert    | O(log n)       | O(n)                     |
    | Delete    | O(log n)       | O(n)                     |
    | Traversal | O(n)           | O(n)                     |



Uses of Binary Trees
    - Binary Search Trees (BSTs) for searching.
    - Expression Trees (used in compilers).
    - Heaps (priority queues).
    - Huffman Coding Trees (compression).
    - Routing Algorithms (networking).

*/



class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}

class  BinaryTree{
    Node root;

    // Inorder Traversal
    void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    // Preorder Traversal
    void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    // Postorder Traversal
    void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    // Height of tree
    int height(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    
}




public class L01_Binary_Tree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(10);
        tree.root.left = new Node(20);
        tree.root.right = new Node(30);
        tree.root.left.left = new Node(40);
        tree.root.left.right = new Node(50);

        System.out.print("Inorder: ");
        tree.inorder(tree.root);
        System.out.print("\nPreorder: ");
        tree.preorder(tree.root);
        System.out.print("\nPostorder: ");
        tree.postorder(tree.root);

        System.out.println("\nHeight of tree: " + tree.height(tree.root));
    }
}
