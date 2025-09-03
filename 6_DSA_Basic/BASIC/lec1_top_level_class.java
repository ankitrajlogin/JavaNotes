
// What is a Class in Java?
// A class is a blueprint for creating objects. It defines:
// Fields (variables)
// Methods (functions)
// Constructors
// Blocks, inner classes, etc.


// What is a Top-Level Package-Private Class in Java?
// Top-Level Class - A top-level class is a class that is not declared inside another class.

// Java does not allow private or protected top-level classes. And also public class can be also be a 1 per file. 



// Top-level classes are part of the package-level scope. So:
// | Modifier                        | Allowed for Top-Level Class? | Why                                                                |
// | ------------------------------- | ---------------------------- | ------------------------------------------------------------------ |
// | `public`                        | ✅ Yes                        | Needed to allow usage from other packages                          |
// | *no modifier* (package-private) | ✅ Yes                        | Visible only in the same package                                   |
// | `protected`                     | ❌ No                         | `protected` applies to **inheritance**, not top-level classes      |
// | `private`                       | ❌ No                         | Makes no sense — class would be invisible even to the same package |


// Summary
// 1. A top-level class is declared outside of any other class.
// 2. If it has no modifier, it’s package-private: accessible only inside its package.
// 3. Only two access levels are valid for top-level classes:
//    i . public
//    ii . (default) (package-private)
// 4. private and protected are not allowed for top-level classes, because they are meaningless at the package level.
