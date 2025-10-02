

// Node class for AVL Tree
class Node {
    int key, height;
    Node left, right;

    Node(int d) {
        key = d;
        height = 1; // New node is initially at height 1
    }
}

// AVL Tree class
class AVLTree {
    Node root;

    // Utility: Get height of a node
    int height(Node n) {
        if (n == null) return 0;
        return n.height;
    }

    // Utility: Get balance factor of a node
    int getBalance(Node n) {
        if (n == null) return 0;
        return height(n.left) - height(n.right);
    }

    // Utility: Get maximum of two numbers
    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // Right rotate subtree rooted with y (LL case)
/*
        x                         y
       / \                       / \
      T1  y        ----->       x   T3
         / \                   / \
        T2  T3                T1  T2
*/
    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    // Left rotate subtree rooted with x (RR case)
/*
        x                         y
       / \                       / \
      T1  y        ----->       x   T3
         / \                   / \
        T2  T3                T1  T2
*/

    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    // left right rotate 
/*
        x                           x                           z
       / \                         / \                        /   \
      y   T4      LeftRotate(y)   z   T4     RightRotate(x)  y     x
     / \          ----------->   / \         ------------>  / \   / \
    T1  z                       y   T3                     T1 T2 T3 T4
       / \                     / \
      T2  T3                  T1  T2
*/
    Node leftRightRotate(Node x){
        x.left = leftRotate(x.left);
        return rightRotate(x);
    }

    // Right left rotate 
/*
        x                             x                             z
       / \                           / \                          /   \
      T1  y        RightRotate(y)   T1  z        LeftRotate(x)   x     y
         / \      ------------->       / \      ------------->  / \   / \
        z   T4                       T2   y                   T1 T2 T3 T4
       / \                               / \
      T2  T3                            T3  T4
*/


    Node rightLeftRotate(Node x){
        x.right = rightRotate(x.right) ; 
        return leftRotate(x) ; 
    }

    // Insert a node
    Node insert(Node node, int key) {
        // 1. Perform normal BST insertion
        if (node == null) return (new Node(key));

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else
            return node; // Duplicate keys not allowed

        // 2. Update height of this ancestor node
        node.height = 1 + max(height(node.left), height(node.right));

        // 3. Get balance factor
        int balance = getBalance(node);

        // 4. If node becomes unbalanced, check 4 cases

        // Case 1: Left Left
        if (balance > 1 && key < node.left.key) {
            System.out.println("LL Rotation on " + node.key);
            return rightRotate(node);
        }

        // Case 2: Right Right
        if (balance < -1 && key > node.right.key) {
            System.out.println("RR Rotation on " + node.key);
            return leftRotate(node);
        }

        // Case 3: Left Right
        if (balance > 1 && key > node.left.key) {
            System.out.println("LR Rotation on " + node.key);
            return leftRightRotate(node) ; 
        }

        // Case 4: Right Left
        if (balance < -1 && key < node.right.key) {
            System.out.println("RL Rotation on " + node.key);
            return rightLeftRotate(node) ; 
        }

        // Return unchanged node pointer
        return node;
    }


    // Find node with minimum key in a subtree 
    Node minValueNode(Node node){
        Node current = node ; 
        while(current.left != null){
            current = current.left ; 
        }
        return current ; 
    }

    // Delete a node 
    Node deleteNode(Node root , int key){
        // 1. Perform stardard BST deletion 
        if(root == null){
            return root ; 
        }

        if(key < root.key){
            root.left = deleteNode(root.left , key) ; 
        }
        else if(key > root.key){
            root.right = deleteNode(root.right , key) ; 
        }
        else{
            if(root.left == null || root.right == null){
                Node temp = (root.left != null) ? root.left : root.right ; 

                // No child case 
                if(temp == null){
                    temp = root ; 
                    root = null ; 
                }
                else{
                    root = temp ; 
                }
            }
            else{
                Node temp = minValueNode(root.right) ;
                root.key = temp.key ; 
                root.right = deleteNode(root.right , key) ; 
            }
        }

        // If the tree had only one node 
        if(root == null){
            return root ; 
        }

        // 2. Update height ;
        root.height = 1 + Math.max(height(root.left) , height(root.right)) ; 

        // 3. Get balance factor 
        int balance = getBalance(root) ;

        // 4. Check 4 cases 

        // left left 
        if(balance > 1 && getBalance(root.left) >= 0){
            return rightRotate(root) ; 
        }

        // left right 
        if(balance > 1 && getBalance(root.left) < 0){
            return leftRightRotate(root) ; 
        }

        // Right Right
        if(balance < -1 && getBalance(root.right) <= 0){
            return leftRotate(root) ; 
        }

        // right left 
        if(balance < -1 && getBalance(root.right) > 0){
            return rightLeftRotate(root) ; 
        }

        return root ; 
    }


     // Recursive function to delete all nodes
    Node deleteEntireTree(Node root) {
        if (root == null)
            return null;

        // Recursively delete left and right subtrees
        root.left = deleteEntireTree(root.left);
        root.right = deleteEntireTree(root.right);

        // Disconnect current node
        root = null; // This allows garbage collection
        return null;
    }






    // Preorder traversal of AVL Tree
    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // Inorder traversal (sorted order)
    void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.key + " ");
            inOrder(node.right);
        }
    }

    
}


public class L02_implementation {

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        /* Insertions */
        System.out.println("\nAdding the key 10") ; 
        tree.root = tree.insert(tree.root, 10);

        System.out.println("\nAdding the key 20") ; 
        tree.root = tree.insert(tree.root, 20);
        
        System.out.println("\nAdding the key 30") ; 
        tree.root = tree.insert(tree.root, 30); // RR case
        
        System.out.println("\nAdding the key 40") ; 
        tree.root = tree.insert(tree.root, 40);
        
        System.out.println("\nAdding the key 50") ; 
        tree.root = tree.insert(tree.root, 50);
        
        System.out.println("\nAdding the key 60") ; 
        tree.root = tree.insert(tree.root, 25); // LR case

        /* Print traversals */
        System.out.println("\nPreorder traversal (root-left-right):");
        tree.preOrder(tree.root);

        System.out.println("\nInorder traversal (sorted order):");
        tree.inOrder(tree.root);



        System.out.println("\nCreating new tree") ; 
        AVLTree tree1 = new AVLTree();

        /* Insertions */
        System.out.println("\nAdding the key 40") ; 
        tree1.root = tree1.insert(tree1.root, 40);

        System.out.println("\nAdding the key 50") ; 
        tree1.root = tree1.insert(tree1.root, 50);
        
        System.out.println("\nAdding the key 30") ; 
        tree1.root = tree1.insert(tree1.root, 30); // RR case
        
        System.out.println("\nAdding the key 10") ; 
        tree1.root = tree1.insert(tree1.root, 10);
        
        System.out.println("\nAdding the key 20") ; 
        tree1.root = tree1.insert(tree1.root, 20);
        
        System.out.println("\nAdding the key 15") ; 
        tree1.root = tree1.insert(tree1.root, 15);

        System.out.println("\nAdding the key 17") ; 
        tree1.root = tree1.insert(tree1.root, 17); // LR case

        System.out.println("\nAdding the key 12") ; 
        tree1.root = tree1.insert(tree1.root, 12); // LR case

        System.out.println("\nAdding the key 11") ; 
        tree1.root = tree1.insert(tree1.root, 11); // LR case


        tree1.root = tree.deleteNode(tree1.root, 40); // delete root node
        System.out.println("Inorder traversal after deletion:");
        tree1.inOrder(tree1.root);
    }

}


// --------------------------------------
//  output 
// --------------------------------------

// RR Rotation on 10
// RR Rotation on 30
// RL Rotation on 20

// Preorder traversal (root-left-right):
// 30 20 10 25 40 50
// Inorder traversal (sorted order):
// 10 20 25 30 40 50


/* 
// ----------------------------------------------
Intuition of rotation :
// ----------------------------------------------

Rotations don’t break BST property because they only swap parent-child relationships.

They reduce the height of the longer side and increase the height of the shorter side → bringing BF back to {-1,0,1}.

Think of it as pivoting around a node so the tall branch “falls into place.”





// -------------------------------------------
Intitution of deleting a node 
// -------------------------------------------

If the tree/subtree is empty, just return null.
If key is smaller than root.key, go to the left subtree.
If key is larger than root.key, go to the right subtree.

Case 1: Node has 0 or 1 child
    - If both children are null, just remove the node.
    - If only one child exists, replace the node with that child.

Case 2: Node has 2 children
    - Find the inorder successor (smallest node in the right subtree).
    - Copy its value to root.key.
    - Delete the inorder successor node from the right subtree.

✅ At this point, the node has been deleted like in a normal BST.







// -------------------------------------------------------
Rotation during Insertion and deletion in avl tree. 
// -------------------------------------------------------

Why do we compare getBalance during deletion?

After deleting a node, the heights of ancestor nodes may decrease, which can make a subtree unbalanced.

    int balance = getBalance(root);

    balance = height(left) - height(right)

    If balance > 1 → left-heavy
    If balance < -1 → right-heavy

Then we check the balance of the child to know which rotation case it is:

    // Left Right case
    if (balance > 1 && getBalance(root.left) < 0)

    balance > 1 → root is left-heavy
    getBalance(root.left) < 0 → left child is right-heavy

So we do double rotation (LR).

The key point: we check the balance factors rather than comparing keys because deletion can shrink subtrees anywhere. The imbalance is caused by height changes, not just the position of the new key.

---



During insertion:
You know exactly where you inserted the new key (it always goes to a leaf).
Therefore, imbalance can only occur along the path from the inserted node up to the root.
In most textbooks/examples, they use key comparisons to detect the rotation case:

    // Example for insertion:
    if (balance > 1 && key < root.left.key) -> LL
    if (balance > 1 && key > root.left.key) -> LR
    if (balance < -1 && key > root.right.key) -> RR
    if (balance < -1 && key < root.right.key) -> RL

Here, key is the newly inserted key.

It works because insertion adds a new leaf, so the imbalance is always caused by that key’s position.

---

Can you use getBalance like in deletion for insertion?
✅ Yes, you can. Instead of comparing the new key with child keys, you can:
Compute the balance factor of the root (balance = height(left) - height(right)).
Check the balance factor of the children to decide rotation:

    if (balance > 1 && getBalance(root.left) >= 0) -> LL
    if (balance > 1 && getBalance(root.left) < 0) -> LR
    if (balance < -1 && getBalance(root.right) <= 0) -> RR
    if (balance < -1 && getBalance(root.right) > 0) -> RL

This works for both insertion and deletion.

Many modern AVL implementations use balance-factor based checks only, instead of comparing keys.
It’s slightly more general and avoids relying on the actual inserted key.

---

✅ Summary

| Operation  | Classic method           | Balance-factor method      |
|------------|-------------------------|---------------------------|
| Insertion  | Compare key with child   | Compare getBalance(child) |
| Deletion   | Compare key not needed   | Must use getBalance(child)|

Key comparison works for insertion because you know where you inserted.
Balance-factor comparison works for both insertion and deletion and is more general.
-->

*/