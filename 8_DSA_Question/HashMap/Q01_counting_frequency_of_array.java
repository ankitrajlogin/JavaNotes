

// Given an array arr[] of non-negative integers which may contain duplicate elements. Return the frequency of each distinct element present in the array.

import java.util.* ; 

public class Q01_counting_frequency_of_array {

    public static ArrayList<ArrayList<Integer>> countFreq(int[] arr){
        
        // stores frequency of each number 
        // new HashMap<>() becomes new HashMap<Integer, String>() internally
        HashMap<Integer , Integer> mp = new HashMap<>() ; 

        for(int num : arr){
            mp.put(num , mp.getOrDefault(num , 0) +1) ; 

            // or
            // if(mp.containsKey(num)){
            //     mp.put(num , mp.get(num)) ; 
            // }
            // else{
            //     mp.put(num , 1) ; 
            // }
        }


        // build answer 
        ArrayList<ArrayList<Integer>>ans = new ArrayList<>() ; 
        for(Map.Entry<Integer, Integer> entry : mp.entrySet()){
            ArrayList<Integer>temp = new ArrayList<>() ; 
            temp.add(entry.getKey())  ; 
            temp.add(entry.getValue()) ; 
            ans.add(temp) ; 
        }

        return ans ; 
    }

    public static void main(String[] args){
        int[] arr = {10 , 20 , 10 , 5 , 20} ;

        ArrayList<ArrayList<Integer>> ans = countFreq(arr) ; 


        ans.sort((a , b) -> 
            Integer.compare(a.get(0) , b.get(0))
        ) ;

        for(ArrayList<Integer> x : ans){
            System.out.println(x.get(0) + " " + x.get(1)) ;
        }


    }
    
}
