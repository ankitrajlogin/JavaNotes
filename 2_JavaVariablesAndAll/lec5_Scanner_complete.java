


import java.util.Scanner;

class InputExample {
    public static void InputDisplay(Scanner sc) {
        System.out.print("Enter your name: ");
        sc.nextLine(); // clear leftover newline if needed
        String name = sc.nextLine();

        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        System.out.print("Enter your salary: ");
        double salary = sc.nextDouble();

        System.out.print("Are you a student? (true/false): ");
        boolean isStudent = sc.nextBoolean();

        System.out.println("\n--- User Info ---");
        System.out.println("Name     : " + name);
        System.out.println("Age      : " + age);
        System.out.println("Salary   : " + salary);
        System.out.println("Student? : " + isStudent);
    }
}

public class lec5_Scanner_complete {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter single word name: ");
        String name = sc.next(); 
        System.out.println("You entered: " + name);

        // Call the method and pass the same scanner
        InputExample.InputDisplay(sc);

        sc.close(); // close it at the end
    }
}

