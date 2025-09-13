


class NumberToWordIterative{

    // Arrays for mapping numbers to words
    private static final int[] values = {
        1000000000, 1000000, 1000, 100, 
        90, 80, 70, 60, 50, 40, 30, 20,
        19, 18, 17, 16, 15, 14, 13, 12, 11, 10,
        9, 8, 7, 6, 5, 4, 3, 2, 1
    };

    private static final String[] words = {
        "Billion", "Million", "Thousand", "Hundred",
        "Ninety", "Eighty", "Seventy", "Sixty", "Fifty",
        "Forty", "Thirty", "Twenty",
        "Nineteen", "Eighteen", "Seventeen", "Sixteen", "Fifteen",
        "Fourteen", "Thirteen", "Twelve", "Eleven", "Ten",
        "Nine", "Eight", "Seven", "Six", "Five", "Four",
        "Three", "Two", "One"
    };


    public static String convertToWords(int n){
        if(n == 0) return "zero" ; 

        StringBuilder result = new StringBuilder() ; 

        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            String word = words[i];

            if (n >= value) {
                int count = n / value; // how many times this value fits
                n %= value;

                // Handle values >= 100 (need to prefix with "X Hundred / Thousand / Million")
                if (value >= 100) {
                    result.append(convertToWords(count)).append(" ");
                }

                result.append(word);

                if (n > 0) result.append(" ");
            }
        }

        return result.toString().trim();
    }




}

public class Q03_NumberToWordIterative {
    public static void main(String[] args) {
        int[] testNumbers = {0, 15, 123, 1005, 12345, 1000000, 2147483647 };

        for (int n : testNumbers) {
            System.out.println(n + " -> " + NumberToWordIterative.convertToWords(n));
        }
    }
    
}
