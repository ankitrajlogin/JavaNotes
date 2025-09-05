

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Q02_FindNthNodeFromLast {

    // Function to find nth node from end
    public static Node findNthFromEnd(Node head, int n) {
        if (head == null) return null;

        Node first = head;
        Node second = head;

        // Move first pointer n steps ahead
        for (int i = 0; i < n; i++) {
            if (first == null) return null; // If n > length
            first = first.next;
        }

        // Move both pointers until first reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        return second; // Second is now at nth node from end
    }

    // Helper function to print the linked list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        // Create list: 1 -> 2 -> 3 -> 4 -> 5 -> NULL
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Original List:");
        printList(head);

        int N = 2;
        Node nthNode = findNthFromEnd(head, N);
        if (nthNode != null) {
            System.out.println(N + "th node from end is: " + nthNode.data);
        } else {
            System.out.println("List has fewer than " + N + " nodes.");
        }
    }
}
