


class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}


class DoublyLinkedList {
    private Node head;
    private Node tail;

    // Insert at head
    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Insert at tail
    public void insertAtTail(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Delete a node
    public void delete(int data) {
        Node curr = head;
        while (curr != null) {
            if (curr.data == data) {
                if (curr == head) {
                    head = head.next;
                    if (head != null) head.prev = null;
                } else if (curr == tail) {
                    tail = tail.prev;
                    if (tail != null) tail.next = null;
                } else {
                    curr.prev.next = curr.next;
                    curr.next.prev = curr.prev;
                }
                return; // deleted, exit
            }
            curr = curr.next;
        }
        System.out.println("Node " + data + " not found!");
    }

    // Display forward
    public void displayForward() {
        Node curr = head;
        System.out.print("Forward: ");
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    // Display backward
    public void displayBackward() {
        Node curr = tail;
        System.out.print("Backward: ");
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.prev;
        }
        System.out.println();
    }
}



public class lec3_double_LinkedList_implementation {
      public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.insertAtHead(10);
        dll.insertAtHead(20);
        dll.insertAtTail(5);
        dll.insertAtTail(1);

        dll.displayForward();   // 20 10 5 1
        dll.displayBackward();  // 1 5 10 20

        dll.delete(10);
        dll.displayForward();   // 20 5 1
        dll.displayBackward();  // 1 5 20
    }
    
}
