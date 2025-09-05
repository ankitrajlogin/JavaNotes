

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Q01_ReverseLinkedList {
    public static Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node nextNode = curr.next; // store next
            curr.next = prev;              // reverse link
            prev = curr;                   // move prev forward
            curr = nextNode;               // move curr forward
        }
        return prev; // new head
    }


    // -------------------------------------
    // Reversive the linked list using recursion 
    // -------------------------------------

    public static Node reverseListRecursive(Node head){
        if(head == null || head.next == null){
            return head;  
        }

        Node newHead = reverseListRecursive(head.next) ; 
        head.next.next = head ; 
        head.next = null ;

        return newHead ; 
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        // Create linked list: 1 -> 2 -> 3 -> 4 -> 5 -> NULL
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Original Linked List:");
        printList(head);

        head = reverseList(head);

        System.out.println("Reversed Linked List:");
        printList(head);
    }
}




/* 
-------------------------------------
Reversive the linked list 
-------------------------------------


1 -> 2 -> 3 -> 4 -> NULL

🔄 Recursive Steps
Step A: First call with head = 1
    Calls recursion on 2 -> 3 -> 4 -> NULL.

Step B: Second call with head = 2
    Calls recursion on 3 -> 4 -> NULL.

Step C: Third call with head = 3
    Calls recursion on 4 -> NULL.

Step D: Fourth call with head = 4
    Base case hit → returns 4.


    
⚡ Backtracking Process
1. Now recursion starts returning and reversing links:
    1. When head = 3
    - newHead = 4
    - head.next.next = head → 4 -> 3
    - head.next = null → breaks 3 -> 4
    - Now list: 4 -> 3 -> NULL
    - Returns 4.

    2. When head = 2
    - newHead = 4
    - head.next.next = head → 3 -> 2
    - head.next = null → breaks 2 -> 3
    - Now list: 4 -> 3 -> 2 -> NULL
    - Returns 4.
    
    3. When head = 1
    - newHead = 4
    - head.next.next = head → 2 -> 1
    - head.next = null → breaks 1 -> 2
    - Now list: 4 -> 3 -> 2 -> 1 -> NULL
    - Returns 4.
    - ✅ Final Output:

4 -> 3 -> 2 -> 1 -> NULL



 */

