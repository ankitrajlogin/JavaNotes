

import java.util.Scanner;



class InputExample{
    public static void InputDisplay(){
        Scanner sc = new Scanner(System.in) ; 

        System.out.print("Enter your name: ");
        String name = sc.nextLine();  // Reads a full line

        System.out.print("Enter your age: ");
        int age = sc.nextInt();       // Reads an integer

        System.out.print("Enter your salary: ");
        double salary = sc.nextDouble(); // Reads a double

        System.out.print("Are you a student? (true/false): ");
        boolean isStudent = sc.nextBoolean(); // Reads a boolean

        System.out.println("\n--- User Info ---");
        System.out.println("Name     : " + name);
        System.out.println("Age      : " + age);
        System.out.println("Salary   : " + salary);
        System.out.println("Student? : " + isStudent);

        sc.close() ; 
        
    }
}

public class lec4_Scanner {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in) ; 
        String name = sc.next() ; 
        System.out.println(name) ; 

        // input :: ankit raj
        // output :: ankit

        sc.close() ; // closes scanner , removes warning . 



        
        InputExample.InputDisplay();


    }   
}

// NOTE : Both are trying to read from the same standard input, which is risky. Once you close the first Scanner, the System.in stream is also closed, so when InputDisplay() tries to read input using another Scanner, it may throw:

// java.util.NoSuchElementException or IllegalStateException
