






/*
    🔹 Structure of Trie Node
        Each node contains:
            - Children → An array of references to child nodes (a–z, i.e., 26 slots for lowercase English letters).
            - wordCount → How many times a word ends at this node.
            - prefixCount → How many words share this prefix.
 */





// TrieNode class represents each node in the Trie
class TrieNode{
    TrieNode[] children ; // Array to store references to child nodes for each character 'a'-'z'
    int wordCount ;       // Number of words ending at this node
    int prefixCount ;     // Number of words having the prefix up to this node

    TrieNode(){
        children = new TrieNode[26] ; // 26 lowercase English letters
        wordCount = 0 ; 
        prefixCount = 0 ; 
    }
}

// Trie class encapsulates all Trie operations
class Trie{
    private TrieNode root ; // Root node of the Trie

    public Trie(){
        root = new TrieNode() ; 
    }

    // Insert a word into the trie  
    public void insert(String word){
        TrieNode node = root ; 

        for(char ch : word.toCharArray()){
            int index = ch-'a' ; 

            // Create a new node if path does not exist
            if(node.children[index] == null){
                node.children[index] = new TrieNode() ; 
            }

            node = node.children[index] ; 
            node.prefixCount++ ; // Increment prefix count for each node in the path
        }

        node.wordCount++ ; // Increment word count at the end node
    }

    // Count how many times word exists in the trie
    public int countWordsEqualTo(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (node.children[idx] == null) return 0; // Word does not exist
            node = node.children[idx];
        }
        return node.wordCount; // Return count at the end node
    }

    // Count how many words start with given prefix
    public int countWordsStartingWith(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            int idx = ch - 'a';
            if (node.children[idx] == null) return 0; // Prefix does not exist
            node = node.children[idx];
        }
        return node.prefixCount; // Return prefix count at the last node of prefix
    }

    // Erase one occurrence of a word from the trie 
    public void erase(String word){
        // If word does not exist, do nothing
        if(countWordsEqualTo(word) == 0) return ;  // safety check ; 

        TrieNode node = root ; 

        for(char ch : word.toCharArray()){
            int index = ch - 'a' ; 
            TrieNode child = node.children[index] ; 
            child.prefixCount-- ; // Decrement prefix count

            // If no word passes through this node anymore, remove reference to free memory
            if(child.prefixCount == 0){
                node.children[index] = null ; 
                return ; 
            }

            node = child ; 
        }

        node.wordCount-- ; // Decrement word count at the end node
    }

    // Clear entire Trie (release memory)
    public void clear(){
        root = null ; // Dereference root for garbage collection
    }
}

// Main class to demonstrate Trie operations
public class L02_TrieImplementation2 {
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple"); // Insert "apple"
        trie.insert("apple"); // Insert "apple" again
        trie.insert("app");   // Insert "app"

        System.out.println(trie.countWordsEqualTo("apple")); // 2
        System.out.println(trie.countWordsStartingWith("app")); // 3
        System.out.println(trie.countWordsEqualTo("app")); // 1

        trie.erase("apple"); // Remove one "apple"
        System.out.println(trie.countWordsEqualTo("apple")); // 1

        trie.erase("apple"); // Remove another "apple"
        System.out.println(trie.countWordsEqualTo("apple")); // 0

        trie.clear(); // Free memory by clearing the Trie
    }
}

/*
    This implementation supports:
    - Inserting words (with duplicate support)
    - Counting exact word occurrences
    - Counting words with a given prefix
    - Erasing a word occurrence
    - Clearing the entire Trie



Time Complexity summary 

| Operation               | Complexity |
| ----------------------- | ---------- |
| Insert(word)            | O(L)       |
| CountWordsEqualTo(word) | O(L)       |
| CountWordsStartingWith  | O(L)       |
| Erase(word)             | O(L)       |
| Clear()                 | O(1)       |

*/