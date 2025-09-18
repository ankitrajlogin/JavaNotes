

// 👉 Generates all subsets.

public class lec02_AllSubsets {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int n = arr.length;
        for (int mask = 0; mask < (1 << n); mask++) {
            System.out.print("{ ");
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println("}");
        }

    }
}
