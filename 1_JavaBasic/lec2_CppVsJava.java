

// 1. Compilation Process

// ✅ Java:
// Source Code → MyClass.java
// Compiled to → MyClass.class
// This .class file contains bytecode, which is not machine code.
// It runs on the Java Virtual Machine (JVM), not directly on your OS.
// Java Code → Bytecode (.class) → JVM interprets/runs it

// ✅ C++:
// Source Code → MyClass.cpp
// Compiled directly to → program.exe (Windows) or a native binary.
// .exe is a machine code binary, ready to run directly on your OS.
// C++ Code → Machine Code (.exe) → OS runs it directly



// 2. Execution Process
// ✅ Java:// The JVM interprets the bytecode and executes it.

// ✅ C++: The OS runs the machine code directly, without an interpreter.


// 3. Platform Dependency
// | Language | File     | Runs On | Platform Dependent?             |
// | -------- | -------- | ------- | ------------------------------- |
// | Java     | `.class` | JVM     | ❌ No (Write once, run anywhere) |
// | C++      | `.exe`   | OS      | ✅ Yes (Platform-specific)       |


// 4. Why the difference?
// Java is interpreted by JVM, so it compiles to a universal format (.class) that JVMs can understand on any platform.
// C++ is compiled to machine code, targeting a specific processor and OS (like Windows or Linux).



public class lec2_CppVsJava {
    public static void main(String[] args) {
        System.out.println("Java vs C++ Compilation and Execution");
    }
}
