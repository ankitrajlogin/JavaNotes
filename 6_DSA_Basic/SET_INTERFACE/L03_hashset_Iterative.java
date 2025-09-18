


/* 
Iterating over a HashSet in Java
======================================
    - A HashSet in Java does not maintain order (unlike LinkedHashSet or TreeSet). But Java provides multiple ways to iterate through it:

1. Using Iterator
    - This is the most common and preferred way.
    - We use iterator() method of HashSet.
    - Supports fail-fast behavior (if the set is structurally modified during iteration ConcurrentModificationException is thrown).


2. Using Enhanced For Loop (for-each)
    - Internally uses an Iterator.
    - More readable and concise.


3. Using forEach() method with Lambda (Java 8+)
    - Uses functional programming style.
    - Cleaner but less flexible than iterator.


*/

import java.util.HashSet;
import java.util.Iterator;


public class L03_hashset_Iterative {
     public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("Apple");
        set.add("Banana");
        set.add("Mango");
        set.add("Orange");
        

        // 1. Iterator() ; 
        System.out.println("Printing the value using Iterator() :") ; 
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        
        
        // 2. Using Enhanced for loop ( for -each) ; 
        System.out.println("\nPrinting the value using loop :") ; 
        for(String fruit : set){
            System.out.println(fruit) ; 
        }
        
        
        //  3. Using forEach() 
        System.out.println("\nPrinting the value using for each :") ; 
        set.forEach(fruit -> System.out.println(fruit)) ;
    }
    
}
