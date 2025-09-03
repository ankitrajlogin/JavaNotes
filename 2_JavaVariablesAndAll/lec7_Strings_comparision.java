


public class lec7_Strings_comparision {
    public static void main(String args[]){
        String name1 = "a" ;
        String name2 = "A" ; 

        // In Java, > and < can only be used for primitive types like int, double, char, etc.
        // You cannot compare String objects using > or <. 

        // Correct Way: Use .compareTo() or .equals()

        if (name1.compareTo(name2) > 0) {
            System.out.println(name1 + " is greater than 1 " + name2);
        } else if (name1.compareTo(name2) < 0) {
            System.out.println(name1 + " is less than 1" + name2);
        } else {
            System.out.println("Both strings are 1 equal.");
        }

        // output : a is greater than A
        // because 'A' -> 65 and 'a' -> 97 ;

        if('a' > 'A'){
            System.out.println('a' + " is greater than " + 'A');
        }
        else{
            System.out.println( "a is not greater than A") ;
        }
        // we can compare char directly


        if("ankitraj" == "ankitraj"){
            System.out.println("strings are equal") ;
        }
        else{
            System.out.println("string is not equal") ; 
        }

        // String interning means that identical string literals are stored only once in the string pool in memory.
        // So:
        // "ankitraj" == "ankitraj"
        // is comparing the same memory address, so == returns true.
        // This works only for string literals.



        String n1 = "ankitraj" ; 
        String n2 = "ankitraj" ; 

        if(n1 == n2){
            System.out.println("strings are equal") ;
        }
        else{
            System.out.println("string is not equal") ; 
        }
        // n1 == n2 true, because both point to the same object in the pool
        // Java stores string literals in a special area of memory called the String Constant Pool. When a string literal is reused:
        // Java doesn’t create a new object.
        // Instead, it reuses the same memory reference from the pool.

        // == → compares references (memory location) but as both pointing to same memory so true is answer. 


        if(new String("Tony") == new String("Tony")){
            System.out.println("Strings are equal");
        }
        else{
            System.out.println("Strings are not equals because with both are different object") ;
        }


        // Visual example : 
        System.out.println("Final comparision");
        String a = "Java";           // stored in string pool
        String b = "Java";           // reused from pool → same reference

        String c = new String("Java");  // new object on heap

        System.out.println(a == b);    // ✅ true
        System.out.println(a == c);    // ❌ false
        System.out.println(a.equals(c)); // ✅ true




        String sentence = "Ankit raj" ; 
        String last_name = sentence.substring(6,9) ; 
        System.out.println(last_name) ; 


        
 
    }
}



// IMPORTANT TERM 
// | Term                     | Meaning                                                  |
// | ------------------------ | -------------------------------------------------------- |
// | **String Literal**       | Hardcoded string (e.g., `"Hello"`), automatically pooled |
// | **String Constant Pool** | Memory area where Java stores/reuses string literals     |
// | **Interning**            | Java's way of reusing identical strings to save memory   |



// NOTE : 
// Is the Constant Pool Concept Only for Strings?
// 🔸 Yes — in practice, interning like this only applies to String objects.
// Java has a String Constant Pool (a part of the runtime's method area) that's specially designed to optimize memory usage because:
// Strings are used a lot (e.g., keys, logs, messages, user input).
// Strings are immutable, so sharing them across references is safe.

//Strings in the Java is an object of class String , created and managed by the Java String class in java.lang package.
// It feels like a primitive — but it's not. It’s syntactic sugar. It’s still an object.




// What happens internally?
// String name = "ankitraj";
// This does 3 things:
// It creates a String object representing "ankitraj".
// Stores it in the String Constant Pool (if not already present).
// The variable name refers to that object.



// We can also explicitly create a String object:
// String name = new String("ankitraj");
// This creates a new object in the heap (not using the pool).