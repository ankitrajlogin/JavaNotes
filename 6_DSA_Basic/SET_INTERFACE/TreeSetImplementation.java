


/*



🔹 🔹 Important Methods in TreeSet

| Method                 | Description                                   | Time Complexity   |
| ---------------------- | --------------------------------------------- | ----------------- |
| `add(E e)`             | Adds an element (no duplicates)               | **O(log n)**      |
| `remove(Object o)`     | Removes an element                            | **O(log n)**      |
| `contains(Object o)`   | Checks if element exists                      | **O(log n)**      |
| `first()`              | Returns smallest element                      | **O(log n)**      |
| `last()`               | Returns largest element                       | **O(log n)**      |
| `higher(E e)`          | Returns least element strictly greater than e | **O(log n)**      |
| `lower(E e)`           | Returns greatest element strictly less than e | **O(log n)**      |
| `ceiling(E e)`         | Returns least element ≥ e                     | **O(log n)**      |
| `floor(E e)`           | Returns greatest element ≤ e                  | **O(log n)**      |
| `iterator()`           | Returns ascending order iterator              | **O(1)** per step |
| `descendingIterator()` | Returns descending order iterator             | **O(1)** per step |

 */




import java.util.*;



class MyTreeSet<E extends Comparable<E>> {
    private class Node {
        E value;
        Node left, right;

        Node(E value) {
            this.value = value;
        }
    }

    private Node root;
    private int size = 0;

    // Add element
    public boolean add(E value) {
        if (root == null) {
            root = new Node(value);
            size++;
            return true;
        }
        return insert(root, value);
    }

    private boolean insert(Node node, E value) {
        int cmp = value.compareTo(node.value);

        if (cmp == 0) {
            return false; // duplicate not allowed
        } else if (cmp < 0) {
            if (node.left == null) {
                node.left = new Node(value);
                size++;
                return true;
            }
            return insert(node.left, value);
        } else {
            if (node.right == null) {
                node.right = new Node(value);
                size++;
                return true;
            }
            return insert(node.right, value);
        }
    }

    // Check if element exists
    public boolean contains(E value) {
        return search(root, value);
    }

    private boolean search(Node node, E value) {
        if (node == null) return false;

        int cmp = value.compareTo(node.value);

        if (cmp == 0) return true;
        else if (cmp < 0) return search(node.left, value);
        else return search(node.right, value);
    }

    // Remove element (simplified version)
    public boolean remove(E value) {
        if (!contains(value)) return false;
        root = delete(root, value);
        size--;
        return true;
    }

    private Node delete(Node node, E value) {
        if (node == null) return null;

        int cmp = value.compareTo(node.value);

        if (cmp < 0) {
            node.left = delete(node.left, value);
        } else if (cmp > 0) {
            node.right = delete(node.right, value);
        } else {
            // Node found
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            // Replace with inorder successor
            Node min = getMin(node.right);
            node.value = min.value;
            node.right = delete(node.right, min.value);
        }
        return node;
    }

    private Node getMin(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }

    // Size of TreeSet
    public int size() {
        return size;
    }

    // Traverse Inorder (gives sorted elements)
    public void inorderTraversal() {
        inorder(root);
        System.out.println();
    }

    private void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.value + " ");
        inorder(node.right);
    }
}

public class TreeSetImplementation {
    public static void main(String[] args) {
        MyTreeSet<Integer> set = new MyTreeSet<>();

        set.add(50);
        set.add(30);
        set.add(70);
        set.add(20);
        set.add(40);
        set.add(60);
        set.add(80);

        System.out.print("Inorder Traversal (Sorted): ");
        set.inorderTraversal(); // Output: 20 30 40 50 60 70 80

        System.out.println("Contains 40? " + set.contains(40)); // true
        System.out.println("Contains 100? " + set.contains(100)); // false

        set.remove(30);
        System.out.print("After removing 30: ");
        set.inorderTraversal(); // 20 40 50 60 70 80

        System.out.println("Size: " + set.size());
    }
}
