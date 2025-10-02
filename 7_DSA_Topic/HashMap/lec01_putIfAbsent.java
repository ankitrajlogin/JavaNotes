import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;




public class lec01_putIfAbsent {
    public static void main(String [] args){
        Map<String , Integer>mp1 = new HashMap<>() ; 

        String key = "ankit" ; 

        // 1. Using containsKey 
        if (!mp1.containsKey(key)) {
            mp1.put(key, 1);
        }
        else{
            mp1.put(key , mp1.get(key) + 1) ; 
        }


        key = "Rahul" ;

        // 2. Using computeIfAbsent 
        mp1.computeIfAbsent(key, k -> 0) ; 
        mp1.put( key , mp1.get(key) + 1) ; 


        // 3. putIfAbsent 
        mp1.putIfAbsent(key, 0) ; 
        mp1.put(key , mp1.get(key) + 1) ; 


        // 4. getOrDefault 
        mp1.put(key , mp1.getOrDefault(key , 0) + 1) ; 



        // 5. compute 
        mp1.compute("rahul" , (keys , value) -> (value == null) ? 10 : value + 10) ; 



    }
}
