

public class lec01_operator {
    public static void main(String[] args) {
        
        int n = 37; // 100101 in binary
        int i = 2;  // bit position (0-based)

        System.out.println("Initial n = " + n);

        // Check if a number is odd or even
        if ((n & 1) == 0) 
            System.out.println(n + " is Even");
        else 
            System.out.println(n + " is Odd");

        // Get i-th bit (0-based from right)
        int ithBit = (n >> i) & 1;
        System.out.println("\nThe " + i + "-th bit of " + n + " is: " + ithBit);

        // Set i-th bit to 1
        System.out.println("\nBefore setting " + i + "-th bit: " + n);
        n = n | (1 << i);
        System.out.println("After setting " + i + "-th bit: " + n);

        // Clear i-th bit (set to 0)
        System.out.println("\nBefore clearing " + i + "-th bit: " + n);
        n = n & ~(1 << i);
        System.out.println("After clearing " + i + "-th bit: " + n);

        // Toggle i-th bit
        System.out.println("\nBefore toggling " + i + "-th bit: " + n);
        n = n ^ (1 << i);
        System.out.println("After toggling " + i + "-th bit: " + n);

        // Count set bits (Brian Kernighan’s Algorithm)
        int temp = n; 
        int count = 0;
        while (temp > 0) {
            temp = temp & (temp - 1);
            count++;
        }
        System.out.println("\nNumber of set bits in " + n + " = " + count);

        // Check if number is power of 2
        if (n > 0 && (n & (n - 1)) == 0)
            System.out.println(n + " is a Power of 2");
        else
            System.out.println(n + " is NOT a Power of 2");

        // Swap two numbers without temp
        int a = 22; 
        int b = 12; 
        System.out.println("\nBefore swapping -> a: " + a  + " b: " + b); 
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("After swapping  -> a: " + a  + " b: " + b); 

        // Remove the lowest set bit
        System.out.println("\nBefore removing lowest set bit: " + n);
        n = n & (n - 1);
        System.out.println("After removing lowest set bit: " + n);

        // Get only the lowest set bit
        int lowest = n & -n;
        System.out.println("\nLowest set bit of " + n + " is: " + lowest);
    }
}
