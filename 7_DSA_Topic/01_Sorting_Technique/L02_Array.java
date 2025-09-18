
/* 

-------------------------
1. Arrays in Java
-------------------------

    - An array in Java is a special object created with a fixed size.
    - The size of the array is fixed at the time of creation and cannot be changed.
    - The length of the array is stored as a final field (variable) inside the array object itself.
        👉 That’s why you access it as arr.length (a property/field), not as a method.


Example:
    - int[] arr = new int[5];
    - System.out.println(arr.length); // prints 5





--------------------------------------
2. Strings (str.length())
--------------------------------------

    - String is a regular class in java.lang.
    - Its size is stored in a private field (e.g., value.length in newer versions, or count in older).
    - To keep it encapsulated, the designers exposed a method: public int length().
    - So when you call str.length(), the JVM actually makes a method call.

Example:
    - String str = "Hello";
    - System.out.println(str.length());



------------------------------------------------
3. Collections (e.g., ArrayList.size())
------------------------------------------------
    - ArrayList stores elements in an array internally.
    - The number of elements is tracked using a field size.
    - But it’s wrapped in a getter method size().
    - Calling list.size() results in a method invocation in the bytecode.




✅ So the key difference is:
    - arr.length → handled by JVM directly (arraylength instruction).
    - str.length() → normal method call (invokevirtual String.length).
    - list.size() → normal method call (invokevirtual ArrayList.size).
*/