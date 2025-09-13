



class CustomLinkedHashMap<K, V> {
    // Node class (like Entry in HashMap) + doubly linked list
    private class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;   // for hash bucket
        Node<K, V> before; // for doubly linked list
        Node<K, V> after;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int SIZE = 16; // number of buckets
    private Node<K, V>[] table;  // hash table
    private Node<K, V> head, tail; // for insertion order

    // @SuppressWarnings("unchecked")
    public CustomLinkedHashMap() {
        table = new Node[SIZE];
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % SIZE;
    }

    // put method
    public void put(K key, V value) {
        int index = getIndex(key);
        Node<K, V> newNode = new Node<>(key, value);

        Node<K, V> current = table[index];
        Node<K, V> prev = null;

        while (current != null) {
            if (current.key.equals(key)) { 
                current.value = value; // update existing key
                return;
            }
            prev = current;
            current = current.next;
        }

        if (prev == null) {
            table[index] = newNode;
        } else {
            prev.next = newNode;
        }

        // Maintain insertion order via doubly linked list
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.after = newNode;
            newNode.before = tail;
            tail = newNode;
        }
    }

    // get method
    public V get(K key) {
        int index = getIndex(key);
        Node<K, V> current = table[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null; // key not found
    }

    // remove method
    public void remove(K key) {
        int index = getIndex(key);
        Node<K, V> current = table[index];
        Node<K, V> prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                // remove from hash bucket
                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }

                // remove from doubly linked list
                if (current.before != null) {
                    current.before.after = current.after;
                } else {
                    head = current.after; // removing head
                }

                if (current.after != null) {
                    current.after.before = current.before;
                } else {
                    tail = current.before; // removing tail
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    // print in insertion order
    public void printOrder() {
        Node<K, V> current = head;
        while (current != null) {
            System.out.print(current.key + "=" + current.value + " ");
            current = current.after;
        }
        System.out.println();
    }
}



public class LinkedHashMap_Implementation {
    public static void main(String[] args) {
        CustomLinkedHashMap<String, Integer> map = new CustomLinkedHashMap<>();

        map.put("X", 10);
        map.put("A", 20);
        map.put("B", 30);
        map.put("C", 40);

        System.out.println("Get A: " + map.get("A")); // 20
        System.out.println("Get C: " + map.get("C")); // 40

        System.out.print("Insertion order: ");
        map.printOrder(); // X=10 A=20 B=30 C=40

        map.remove("B");
        System.out.print("After removing B: ");
        map.printOrder(); // X=10 A=20 C=40
    }
}
