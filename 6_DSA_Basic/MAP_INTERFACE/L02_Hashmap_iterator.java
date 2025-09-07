import java.util.*;




public class L02_Hashmap_iterator {
    public static void main(String[] args){
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Mango");

        System.out.println("\nprinting map keyset : " + map.keySet());


        // 1. Iterating using keySet()
        //      - Retrieves all keys as a Set<K>.
        //      - You can then use the key to get its value.

        // NOTE : 
        //      - map.keySet() → returns a Set<Integer> (all the keys).
        //      - .iterator() → gets an Iterator<Integer> for that set.
        //      - So, keyIterator is now an object that can move through the keys one at a time.

        Iterator<Integer> keyIterator = map.keySet().iterator();
        while (keyIterator.hasNext()) {
            Integer key = keyIterator.next();
            System.out.println("Key: " + key + ", Value: " + map.get(key));
        }

        // When to use?
        //      - If you need only keys.
        //      - Slightly less efficient if you need values too (because map.get(key) is called each time).





        // 2. Iterating using values() 
        //      - Retrieves all values as a Collection<V>.
        //      - Does not give access to keys.

        Iterator<String> valueIterator = map.values().iterator();
        while (valueIterator.hasNext()) {
            System.out.println("Value: " + valueIterator.next());
        }

        // 🔹 When to use?
        //      - If you only need values (not keys).




        // 3. Iterating using entrySet() 
        //      - Retrieves all entries as a Set<Map.Entry<K,V>>.
        //      - Best way to get both key and value in a single step.

        Iterator<Map.Entry<Integer, String>> entryIterator = map.entrySet().iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<Integer, String> entry = entryIterator.next();
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // 🔹 When to use?
        //      - If you need both keys and values.
        //      - Most efficient approach.




        // 4. Iterating using for-each loop 
        
        // Using keySet()
        for (Integer key : map.keySet()) {
            System.out.println("Key: " + key + ", Value: " + map.get(key));
        }

        // Using entrySet()
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }




    
    }
}
