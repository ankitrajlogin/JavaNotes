

class SettingBit{
    // Function to set the rightmost unset bit
    static int setRightmostUnsetBit(int n) {
        // If all bits are set, just return n
        if (n == 0) return 1;    // special case (binary 0 → set rightmost 0 → 1)
        if (~n == 0) return n;   // all bits are 1 → nothing to set

        // Trick: n | (n + 1) sets the rightmost 0 to 1
        return n | (n + 1);
    }

    static int setRightmostUnsetBit2(int n){
        if(~n == 0) return n ; // all bits set 

        int pos = 0 ; 
        int temp = n ; 

        while((temp & 1) == 1){
            pos++ ; 
            temp >>= 1 ; 
        }

        return n | (1 << pos) ; 
    }


    static int setRightmostUnsetBit3(int n){
        if(~n == 0) return n ; 

        for(int i = 0 ; i< 32 ; i++){
            if((n & (1 << i)) == 0){
                n |= (1 << i) ; 
                break ; 
            }
        }

        return n ; 

    }

    static int setRightmostUnsetBit4(int n) {
        if (~n == 0) return n; // all bits set
        return n | (~n & (n + 1));
    }


}



public class lec05_Set_the_rightmost_unset_bit {
    
    public static void main(String[] args) {
        int n1 = 10;   // 1010
        int n2 = 15;   // 1111
        int n3 = 0;    // 0000

        System.out.println("Original: " + n1 + " → After: " + SettingBit.setRightmostUnsetBit(n1));
        System.out.println("Original: " + n2 + " → After: " + SettingBit.setRightmostUnsetBit(n2));
        System.out.println("Original: " + n3 + " → After: " + SettingBit.setRightmostUnsetBit(n3));
    }
}

/* 

// Summary of methods : 
| Method            | Idea                 | Time Complexity |      |
| ----------------- | -------------------- | --------------- | ---- |
| \`n               | (n+1)\`              | Classic trick   | O(1) |
| Loop with shifts  | Scan until `0` found | O(log n)        |      |
| XOR `(n ^ (n+1))` | Bit pattern trick    | O(1)            |      |
| `~n & (n+1)`      | Isolate unset bit    | O(1)            |      |
| Brute Force loop  | Check all 32 bits    | O(32) \~ O(1)   |      |


*/
