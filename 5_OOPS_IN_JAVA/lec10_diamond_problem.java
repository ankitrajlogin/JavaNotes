

// Java allows multiple inheritance through interfaces.
// So how does Java solve the diamond problem in interfaces?
// Let’s see it with an example.


interface A1 {
    default void show() {
        System.out.println("A");
    }
}

interface B1 extends A1 {
    default void show() {
        System.out.println("B");
    }
}

interface C1 extends A1 {
    default void show() {
        System.out.println("C");
    }
}

// Diamond shape: B and C both extend A
// D implements both B and C

class Demo1 implements B1, C1 {
    public void show() {
        // 👇 Must resolve conflict manually
        C1.super.show();  // or B.super.show();


        // NOTE : 
        // A.super.show();  // Not allowed
        // You cannot directly call A.super.show() in class D, because D doesn't implement A directly, it implements B and C.


    }
}





//  So, How Can You Still Use A's Method?
// To use A's method, you need to remove the overrides in B and C, or manually call A’s implementation from B or C, then call that.



interface a2 {
    default void show() {
        System.out.println("A");
    }
}

interface b2 extends a2 { }

interface c2 extends a2 { }

class Demo2 implements b2, c2 {
   // No override needed 
}




public class lec10_diamond_problem {
    public static void main(String[] args) {
        Demo1 obj1 = new Demo1();
        obj1.show();  // Output: C

        Demo2 obj2 = new Demo2();
        obj2.show();  // Output: A
    }
}
