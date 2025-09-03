import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Fast input and output
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // Ask how many test cases
        bw.write("Enter number of test cases:\n");
        bw.flush(); // Must flush before reading input
        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            // Prompt for input
            bw.write("Test case #" + i + ": Enter two numbers separated by space:\n");
            bw.flush(); // Ensure prompt is printed before input

            String[] parts = br.readLine().split(" ");
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);

            int sum = a + b;

            // Output result
            bw.write("Result for test case #" + i + ": " + sum + "\n");
            bw.flush(); // Optional after each write, but necessary if alternating
        }

        // Clean up
        bw.close();
        br.close();
    }
}


// Important Notes
// Always call bw.flush() right after bw.write() before expecting input from user.

// Without .flush(), your prompts may not appear immediately on the screen.

// For batch-style problems (like CSES), it's better to buffer everything and flush only once at the end.