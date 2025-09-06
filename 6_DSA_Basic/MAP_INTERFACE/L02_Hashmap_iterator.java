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

        Iterator<Integer> keyIterator = map.keySet().iterator() ; 




    
    }
}
