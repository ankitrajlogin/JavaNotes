import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode{
    int data ; 
    List<TreeNode> children ; 

    TreeNode(int value){
        this.data = value ;
        this.children = new ArrayList<>() ; 
    }

    public void addChild(TreeNode child){
        children.add(child) ; 
    }
}

// Tree class 
class GeneralTree{
    public TreeNode root ; 

    public GeneralTree(int rootValue){
        root = new TreeNode(rootValue) ; 
    }

    public void addChild(TreeNode parent , int childValue){
        TreeNode child = new TreeNode(childValue) ; 
        parent.addChild(child) ; 
    }


    public void dfs(TreeNode node){
        if(node == null) return ; 
        System.out.print(node.data + " ") ; 

        for(TreeNode child : node.children){
            dfs(child) ; 
        }
    }

    // Breadth First Search (BFS) - Level Order Traversal
    public void bfs() {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.data + " ");
            queue.addAll(node.children);
        }
    }

    public void bfs2(){
        if(root == null) return ; 

        Queue<TreeNode> queue = new LinkedList<>() ; 
        queue.add(root) ; 

        while(!queue.isEmpty()){
            TreeNode node = queue.poll() ; 
            System.out.print(node.data + " ") ; 

            for(TreeNode n : node.children){
                queue.add(n) ; 
            }
        }
    }


    // search for a node in the tree 
    public boolean search(TreeNode node , int target){
        if(node == null) return false ; 
        if(node.data == target) return true ; 
        for(TreeNode child : node.children){
            if(search(child, target)) return true ; 
        }
        return false ; 
    }

    // Count total number of nodes in tree 
    public int countNodes(TreeNode node){
        if(node == null) return 0 ; 
        int count = 1 ; 

        for(TreeNode child : node.children){
            count += countNodes(child) ; 
        }
        return count ; 
    }

    // Height of the tree (longest path from root to leaf) 
    public int height(TreeNode node){
        if(node == null) return 0 ; 
        int maxHeight = 0 ; 

        for(TreeNode child : node.children){
            maxHeight = Math.max(maxHeight , height(child)) ; 
        }
        return maxHeight + 1; 
    }

    // Print all leaf nodes
    public void printLeaves(TreeNode node) {
        if (node == null) return;
        if (node.children.isEmpty()) {
            System.out.print(node.data + " ");
        }
        for (TreeNode child : node.children) {
            printLeaves(child);
        }
    }

    // Delete a node ( removes node and its subtree) 
    public boolean delete(TreeNode parent , int value){
        Iterator<TreeNode> it = parent.children.iterator() ; 
        while(it.hasNext()){
            TreeNode child = it.next() ; 

            if (child.data == value) {
                it.remove(); // Remove this node
                return true;
            } else {
                if (delete(child, value)) return true;
            }
        }

        return false ;
    }
}


public class L02_Tree_Implementation {

    public static void main(String[] args){
         GeneralTree tree = new GeneralTree(1);

        // Add children to root
        TreeNode root = tree.root;
        tree.addChild(root, 2);
        tree.addChild(root, 3);
        tree.addChild(root, 4);

        // Add children to node 2
        tree.addChild(root.children.get(0), 5);
        tree.addChild(root.children.get(0), 6);

        // Add children to node 3
        tree.addChild(root.children.get(1), 7);
        tree.addChild(root.children.get(1), 8);

        System.out.println("DFS Traversal:");
        tree.dfs(root); // 1 2 5 6 3 7 8 4

        System.out.println("\nBFS Traversal:");
        tree.bfs(); // 1 2 3 4 5 6 7 8


        System.out.println("\nBFS2 Traversal:");
        tree.bfs2(); // 1 2 3 4 5 6 7 8


         System.out.println("\nSearch 7: " + tree.search(root, 7));
        System.out.println("\nTotal Nodes: " + tree.countNodes(root));
        System.out.println("\nTree Height: " + tree.height(root));

        System.out.print("\nLeaf Nodes: ");
        tree.printLeaves(root); // 5 6 7 8 4

        boolean flag = tree.delete(root, 3);
        System.out.println("\nDeleting Node 3... : " + flag );

        System.out.println("\nDFS after deletion:");
        tree.dfs(root); // 1 2 5 6 4
    }
    
}
