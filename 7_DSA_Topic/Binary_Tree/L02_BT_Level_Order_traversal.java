import java.util.LinkedList;
import java.util.Queue;

class Node{
    int data ; 
    Node left , right ; 

    Node(int value){
        data = value ; 
        left = right = null ; 
    }
}

class LevelOrderTraversal{
    void levelOrder(Node node){
        if(node == null) return ; 

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()){
            Node current = queue.poll() ; 

            System.out.print(current.data + " ") ; 

            if(current.left != null) queue.add(current.left) ; 
            if(current.right != null) queue.add(current.right) ; 
        }
    }
}

public class L02_BT_Level_Order_traversal {
    public static void main(String[] args) {
        // Create binary tree:
        //         1
        //        / \
        //       2   3
        //      / \   \
        //     4   5   6

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        LevelOrderTraversal lot = new LevelOrderTraversal();
        System.out.print("Level Order Traversal: ");
        lot.levelOrder(root);
        System.out.println();
    }
}
