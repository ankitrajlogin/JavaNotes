









public class L04_findsuccessor {

    class Node {
		public Node left;
		public Node right;
		public int data;

		public Node(int data) {
			this.data = data;
		}
	}



    // find next successor 
    Node findSuccessor(Node root, Node p) {
	    // add your logic here
		Node successor = null ; 
		Node curr = root ; 
		
		while(curr != null){
			if(p.data < curr.data){
				successor = curr ; 
				curr = curr.left ; 
			}
			else{
				curr = curr.right ; 
			}
		}
		
		return successor ; 
	}


    public static void main(String[] args){
        
    }
    
}
