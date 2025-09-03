



class DoublyLinkedList {

    // Node class (non-static since it uses outer class references)
    private class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    // Add at the front
    public void addFirst(int value) {
        Node newNode = new Node(value);
        newNode.next = head;

        if (head != null) {
            head.prev = newNode;
        } else {
            tail = newNode; // list was empty
        }

        head = newNode;
        size++;
    }

    // Add at the end
    public void addLast(int value) {
        Node newNode = new Node(value);
        newNode.prev = tail;

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

        if (head != null) {
            head.prev = null;
        } else {
            tail = null; // list became empty
        }

        size--;
    }

    // Remove from end
    public void removeLast() {
        if (tail == null) {
            System.out.println("List is empty");
            return;
        }

        tail = tail.prev;

        if (tail != null) {
            tail.next = null;
        } else {
            head = null; // list became empty
        }

        size--;
    }

    // Print from head to tail
    public void printForward() {
        Node current = head;
        System.out.print("Forward: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Print from tail to head
    public void printBackward() {
        Node current = tail;
        System.out.print("Backward: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }

    public int size() {
        return size;
    }

    // Main method to test
  
}




public class lec3_double_LinkedList_implementation {
      public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.addLast(10);
        dll.addLast(20);
        dll.addFirst(5);
        dll.addLast(30);

        dll.printForward();   // Forward: 5 10 20 30
        dll.printBackward();  // Backward: 30 20 10 5

        System.out.println("Size: " + dll.size()); // 4

        dll.removeFirst();
        dll.printForward(); // Forward: 10 20 30

        dll.removeLast();
        dll.printForward(); // Forward: 10 20

        System.out.println("Size: " + dll.size()); // 2
    }
    
}
