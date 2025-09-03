import java.util.LinkedList;


// time compleixity 

// | Operation                  | Time Complexity                   |
// | -------------------------- | --------------------------------- |
// | `addFirst` / `addLast`     | O(1)                              |
// | `add(index, element)`      | O(n)                              |
// | `get(index)`               | O(n)                              |
// | `remove(index)`            | O(n)                              |
// | `removeFirst`/`removeLast` | O(1)                              |
// | `contains(element)`        | O(n)                              |
// | `size()`                   | O(1)                              |
// | `iterator()`               | O(1) (creation), O(n) (iteration) |



public class lec4_Linkedlist_default {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        // Add elements
        list.add("A");
        list.add("B");
        list.add("C");
        System.out.println("After add(): " + list);

        // Add at specific index
        list.add(1, "D");
        System.out.println("After add at index 1: " + list);

        // Add First and Last
        list.addFirst("Start");
        list.addLast("End");
        System.out.println("After addFirst and addLast: " + list);

        // Get element
        System.out.println("Element at index 2: " + list.get(2));

        // Set element
        list.set(2, "Z");
        System.out.println("After set at index 2: " + list);

        // Remove by index and object
        list.remove(2);
        list.remove("B");
        System.out.println("After remove: " + list);

        // Remove first and last
        list.removeFirst();
        list.removeLast();
        System.out.println("After removeFirst and removeLast: " + list);

        // Contains
        System.out.println("Contains C? " + list.contains("C"));

        // Push and Pop (Stack operations)
        list.push("X"); // adds to front
        System.out.println("After push: " + list);
        list.pop();     // removes from front
        System.out.println("After pop: " + list);

        // Peek and Poll (Queue operations)
        System.out.println("Peek: " + list.peek());
        list.poll(); // removes first
        System.out.println("After poll: " + list);

        // Size
        System.out.println("Size: " + list.size());

        // Clear
        list.clear();
        System.out.println("After clear: " + list);
    }
}
