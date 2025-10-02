import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PrimeFactors{
    public static List<Integer> printPrimeFactor(int n){
        List<Integer> answer = new ArrayList<>() ; 
        
        // handle 2 separately 
        while(n % 2 == 0){
            System.out.println(2 + " ") ; 
            answer.add(2) ; 
            n/= 2 ; 
        }

        // Handle odd number 
        for(int i = 3 ; i<= Math.sqrt(n) ; i+=2){
            while(n% i == 0){
                System.out.println(i + " ") ; 
                answer.add(i) ; 
                n /= i ; 
            }
        }

        if(n > 2){
            System.out.print(n + "\n") ; 
            answer.add(n ) ; 
        }
        return answer ;     
    }

    public static List<Integer> printPrimeFactorSieve(int n){
        List<Integer> answer = new ArrayList<>() ; 

        int limit = (int)Math.sqrt(n) ; 
        boolean[] isPrime = new boolean[limit + 1] ;
        Arrays.fill(isPrime , true) ; 
        isPrime[0] = isPrime[1] = false ; 

        // Sieve 
        for(int i = 2 ; i*i <= limit ; i++){
            if(isPrime[i]){
                for(int j = i*i ; j <= limit ; j+= i){
                    isPrime[j] = false ; 
                }
            }
        }

        // Use primes to divide n
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                while (n % i == 0) {
                    System.out.println(i + " ");
                    answer.add(i) ; 
                    n /= i;
                }
            }
        }
        if (n > 1) System.out.print(n + "\n");

        return answer ; 

    }


    public static List<Integer> printUniquePrimeFactor(int n){
        List<Integer> answer = new ArrayList<>() ; 
        
        // handle 2 separately 
        if(n % 2 == 0){
            System.out.println(2 + " ") ; 
            answer.add(2) ; 

            while(n%2 == 0){
                n/= 2 ; 
            }
        }

        // Handle odd number 
        for(int i = 3 ; i<= Math.sqrt(n) ; i+=2){
            if(n%i == 0){
                System.out.println(i + " ") ; 
                answer.add(i) ; 
            }

            while(n% i == 0){
                n /= i ; 
            }
        }

        if(n > 2){
            System.out.print(n + "\n") ; 
            answer.add(n ) ; 
        }
        return answer ;     
    }

    public static List<Integer> printUniquePrimeFactorSieve(int n){
        List<Integer> answer = new ArrayList<>() ; 

        int limit = (int)Math.sqrt(n) ; 
        boolean[] isPrime = new boolean[limit + 1] ;
        Arrays.fill(isPrime , true) ; 
        if (limit >= 0) isPrime[0] = false;
        if (limit >= 1) isPrime[1] = false;

        // Sieve 
        for(int i = 2 ; i*i <= limit ; i++){
            if(isPrime[i]){
                for(int j = i*i ; j <= limit ; j+= i){
                    isPrime[j] = false ; 
                }
            }
        }

        // Use primes to divide n
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (isPrime[i] && n % i == 0) {
                answer.add(i);
                System.out.println(i + " ");
                while (n % i == 0) {
                    n /= i;
                }
            }
        }

        // If n > 1, it's a prime factor
        if (n > 1) {
            System.out.println(n);
            answer.add(n);
        }

        return answer ; 

    }
}

public class L01_print_prime_factor {
    public static void main(String[] args){

        List<Integer> answer = PrimeFactors.printPrimeFactor(36) ; 
        System.out.println(answer) ; 


        List<Integer> answer2 = PrimeFactors.printPrimeFactorSieve(36) ;
        System.out.println(answer2) ; 


        List<Integer> answer3 = PrimeFactors.printUniquePrimeFactor(36) ; 
        System.out.println(answer3) ; 


        List<Integer> answer4 = PrimeFactors.printUniquePrimeFactorSieve(31) ;
        System.out.println(answer4) ; 
    }
}
