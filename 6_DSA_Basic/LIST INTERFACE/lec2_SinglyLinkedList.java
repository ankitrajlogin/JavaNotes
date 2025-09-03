
// What is LinkedList?
// LinkedList is a doubly-linked list implementation of the List and Deque interfaces.
// It allows duplicate elements, maintains insertion order, and can be used as a list, queue, or stack.
// Each element is a Node that contains a reference to the previous and next node.


// Simplified internal Node class (used in LinkedList)


// Node.java (can be in same file or separate file if you want to make it public)
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

// Main Singly Linked List class
class SinglyLinkedList {
    private Node head = null;
    private Node tail = null;
    private int size = 0;

    // Add node at the beginning
    public void addFirst(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;

        if (tail == null) {
            tail = newNode; // list was empty
        }

        size++;
    }

    // Add node at the end
    public void addLast(int value) {
        Node newNode = new Node(value);
        if (tail != null) {
            tail.next = newNode;
        } else {
            head = newNode; // list was empty
        }
        tail = newNode;
        size++;
    }

    // Remove from front
    public void removeFirst() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        head = head.next;

        if (head == null) {
            tail = null; // list became empty
        }

        size--;
    }

    // Remove from end
    public void removeLast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.next == null) {
            head = tail = null;
        } else {
            Node current = head;
            while (current.next != tail) {
                current = current.next;
            }

            current.next = null;
            tail = current;
        }

        size--;
    }

    // Print the list
    public void printList() {
        Node current = head;
        System.out.print("List: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public int size() {
        return size;
    }

    // Main method to test
  
}

public class lec2_SinglyLinkedList {

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();

        sll.addFirst(10);
        sll.addLast(20);
        sll.addFirst(5);
        sll.addLast(30);

        sll.printList(); // List: 5 10 20 30

        System.out.println("Size: " + sll.size()); // 4

        sll.removeFirst();
        sll.printList(); // List: 10 20 30

        sll.removeLast();
        sll.printList(); // List: 10 20

        System.out.println("Size: " + sll.size()); // 2

    }

    
}