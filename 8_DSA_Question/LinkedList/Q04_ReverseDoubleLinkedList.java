
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

    // Insert at end
    public void insertAtTail(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
        newNode.prev = curr;
    }

    // Reverse DLL
    public void reverse() {
        Node curr = head;
        Node temp = null;

        while (curr != null) {
            // swap next and prev
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;

            // move to "previous" node (which is next in original list)
            curr = curr.prev;
        }

        // update head
        if (temp != null) {
            head = temp.prev;
        }
    }

    // Display forward
    public void display() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    // Main
    
}



public class Q04_ReverseDoubleLinkedList {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertAtTail(10);
        dll.insertAtTail(20);
        dll.insertAtTail(30);
        dll.insertAtTail(40);

        System.out.print("Original: ");
        dll.display(); // 10 20 30 40

        dll.reverse();

        System.out.print("Reversed: ");
        dll.display(); // 40 30 20 10
    }
    
}
