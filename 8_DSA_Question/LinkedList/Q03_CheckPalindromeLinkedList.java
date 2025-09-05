class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Q03_CheckPalindromeLinkedList {

    // Function to check if linked list is palindrome
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // Step 1: Find middle using slow & fast pointers
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        ListNode secondHalf = reverse(slow.next);

        // Step 3: Compare both halves
        ListNode p1 = head;
        ListNode p2 = secondHalf;
        boolean result = true;

        while (result && p2 != null) {
            if (p1.data != p2.data) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // (Optional) Step 4: Restore list
        slow.next = reverse(secondHalf);

        return result;
    }

    // Reverse helper function
    private static ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // Helper function to print list
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        // Example 1: Palindrome
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(2);
        head1.next.next.next.next = new ListNode(1);

        System.out.println("List 1:");
        printList(head1);
        System.out.println("Is Palindrome? " + isPalindrome(head1));

        // Example 2: Not Palindrome
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);

        System.out.println("\nList 2:");
        printList(head2);
        System.out.println("Is Palindrome? " + isPalindrome(head2));
    }
}
