
/* 
1. Definition
    - A Trie (also called a prefix tree or digital tree) is a tree-like data structure used to efficiently store and retrieve strings, especially when working with prefixes.
        - Each node represents a character.
        - A path from the root to a node represents a prefix of a word.
        - A special flag (isEndOfWord) is used to mark the end of a valid word.


2. Properties
    - Each edge represents a character.
    - Root node is usually empty.
    - Efficient for searching strings with common prefixes.
    - Time complexity:
        - Insert: O(L), where L = length of the word
        - Search: O(L)
        - Delete: O(L)
        - Prefix search: O(L)


3. Applications
    - Autocomplete (search engines, text editors).
    - Spell checking.
    - IP routing (longest prefix matching).
    - Word games (Scrabble, crossword solving).
    - Dictionary implementations.

4. Trie Implementation in Java
    - We’ll implement the following operations:
        1. Insert a word.
        2. Search (check if a word exists).
        3. Delete a word.
        4. Check if a prefix exists.
        5. List all words in the trie.
*/
class TrieNode {
    TrieNode[] children; // array of size 26
    boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Insert a word into the Trie
    public void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    // Search if a word exists in Trie
    public boolean search(String word) {
        TrieNode node = getNode(word);
        return node != null && node.isEndOfWord;
    }

    // Check if any word starts with given prefix
    public boolean startsWith(String prefix) {
        return getNode(prefix) != null;
    }

    // Helper: traverse Trie for a word/prefix
    private TrieNode getNode(String str) {
        TrieNode current = root;
        for (char ch : str.toCharArray()) {
            int index = ch - 'a';
            if (current.children[index] == null) return null;
            current = current.children[index];
        }
        return current;
    }

    // Delete a word from Trie
    public boolean delete(String word) {
        return deleteHelper(root, word, 0);
    }

    private boolean deleteHelper(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.isEndOfWord) return false; // word not found
            current.isEndOfWord = false;
            return isEmpty(current); // if node has no children, delete it
        }

        int i = word.charAt(index) - 'a';
        TrieNode node = current.children[i];
        if (node == null) return false;

        boolean shouldDeleteCurrentNode = deleteHelper(node, word, index + 1);

        if (shouldDeleteCurrentNode) {
            current.children[i] = null;
            return isEmpty(current) && !current.isEndOfWord;
        }
        return false;
    }

    private boolean isEmpty(TrieNode node) {
        for (TrieNode child : node.children) {
            if (child != null) return false;
        }
        return true;
    }

    // Get all words stored in Trie
    public void getAllWords() {
        collectWords(root, new StringBuilder());
    }

    private void collectWords(TrieNode node, StringBuilder prefix) {
        if (node.isEndOfWord) {
            System.out.println(prefix.toString());
        }
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                prefix.append((char) (i + 'a'));
                collectWords(node.children[i], prefix);
                prefix.deleteCharAt(prefix.length() - 1); // backtrack
            }
        }
    }

    // count how many words share the given prefix 
    public int countWordWithPrefix(String prefix){
        TrieNode node = getNode(prefix) ; 

        if(node == null) return 0 ; 

        return countWords(node) ; 
    }

    private int countWords(TrieNode node){
        int count = 0 ; 

        if(node.isEndOfWord) count++ ; 

        for(int i = 0 ; i< 26 ; i++){
            if(node.children[i] != null){
                count += countWords(node.children[i]) ; 
            }
        }

        return count ; 
    }
}

public class L01_TrieImplementation {
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        trie.insert("app");
        trie.insert("bat");
        trie.insert("ball");

        System.out.println("Search 'apple': " + trie.search("apple")); // true
        System.out.println("Search 'batman': " + trie.search("batman")); // false

        System.out.println("Starts with 'ap': " + trie.startsWith("ap")); // true
        System.out.println("Starts with 'ba': " + trie.startsWith("ba")); // true
        System.out.println("Starts with 'ca': " + trie.startsWith("ca")); // false

        System.out.println("All words in Trie:");
        trie.getAllWords();

        trie.delete("app");
        System.out.println("After deleting 'app':");
        trie.getAllWords();
    }
}




// Summary Table 
/*

| Operation                 | Time Complexity | Space Complexity | Notes                              |
| ------------------------- | --------------- | ---------------- | ---------------------------------- |
| Insert(word)              | O(L)            | O(L)             | New nodes created only when needed |
| Search(word)              | O(L)            | O(1)             | Checks `isEndOfWord`               |
| StartsWith(prefix)        | O(L)            | O(1)             | No need to check end of word       |
| Delete(word)              | O(L)            | O(L)             | Recursive removal of unused nodes  |
| GetAllWords()             | O(N × L)        | O(N × L)         | DFS over trie                      |
| CountWordsWithPrefix(pfx) | O(L + K)        | O(K)             | Traverse prefix, then DFS          |


 */







// Map vs Array in Trie 

/* 

| Aspect          | Using Map                                                | Using Array                                       |
| --------------- | -------------------------------------------------------- | ------------------------------------------------- |
| **Flexibility** | Any character set                                        | Fixed alphabet (`a-z`, 26)                        |
| **Memory**      | Space-efficient for sparse alphabets                     | Uses more memory (always size 26 per node)        |
| **Speed**       | O(1) average (hashing) but depends on map implementation | O(1) always (direct index access)                 |
| **Use Case**    | Large alphabets (Unicode, dictionary apps)               | Small fixed alphabets (lowercase English letters) |

*/
