


class IsPowerOfTwo{

    // Using Loop ( divide by 2) ; 
    boolean isPowerofTwo1(int n){
        if(n <= 0) return false ; 

        while(n%2 == 0){
            n/=2 ; 
        }

        return n == 1 ; 
    }

    // using bit manipulation 
    boolean isPowerofTwo2(int n){
        if(n <= 0){
            return false ; 
        }

        if((n & (n-1)) == 0){
            return true ; 
        }

        return false ; 
    }

    // Using bit count ; 
    boolean siPowerofTwo3(int n){
        if(n <= 0){
            return false ; 
        }

        int count = 0; 

        while(n > 0){
            if((n & 1) != 0){
                count++ ; 
            }
            n = n>>1 ; 
        }

        return (count == 1)  ; 
    }
}


public class lec04_Is_power_of_2 {
    
}
