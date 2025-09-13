/*
PROBLEM STATEMENT : 
    - Given an array of strings words[], find the longest string such that every prefix of it is also present in words[]. If multiple strings have the same maximum length, return the lexicographically smallest one.

    - If no such string is found, return an empty string.
 */




class TrieNode{
    TrieNode[] children ; 
    boolean isWordEnd ; 

    TrieNode(){
        children = new TrieNode[26] ;
        this.isWordEnd = false ; 
    }
}

class Trie{
    private TrieNode root ; 

    Trie(){
        root = new TrieNode() ; 
    }


    public void insert(String word){
        TrieNode node = root ; 

        for(char c : word.toCharArray()){
            int index = c - 'a' ; 

            if(node.children[index] == null){
                node.children[index] = new TrieNode() ; 
            }

            node = node.children[index] ; 
        }

        node.isWordEnd = true ; 
    }

    public boolean isComplete(String word){
        TrieNode node = root ; 

        for(char c : word.toCharArray()){
            int index = c-'a' ; 

            node = node.children[index] ; 
            
            if(node == null || !node.isWordEnd) return false ; 
        }

        return true ; 
    }
}

class Solution{

    public String longestCompleteString(String[] words){
        Trie trie = new Trie() ; 

        for(String word : words){
            trie.insert(word);
        }


        String ans = "" ; 

        for(String word : words){
            if(trie.isComplete(word)){
                if(word.length() > ans.length() || 
                    (word.length() == ans.length() && word.compareTo(ans) < 0)){
                        ans = word ; 
                    }
            }
        }


        return ans.isEmpty() ? "None" : ans ; 
    }

}

public class Q01_Longest_String_with_all_prefix {

    public static void main(String[] args){
        Solution sol = new Solution();

        String[] nums1 = {"n", "ni", "nin", "ninj", "ninja", "nil"};
        System.out.println( sol.longestCompleteString(nums1)); // ninja

        String[] nums2 = {"ninja", "night", "nil"};
        System.out.println(sol.longestCompleteString(nums2)); // None

        String[] nums3 = {"cat", "car", "cow", "c", "ca", "t", "r", "w"};
        System.out.println(sol.longestCompleteString(nums3)); // cat
    }


}