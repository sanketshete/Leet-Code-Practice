
public class TreeAncestor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node root = new Node(20);
		Node  node1= new Node(10);
		Node  node2= new Node(8);
		Node  node3= new Node(12);
		Node  node4= new Node(11);
		Node  node5= new Node(13);
		Node  node6= new Node(30);
		
		root.right=node6;
		root.left=node1;
		
		node1.left=node2;
		node1.right=node3;
		node3.left=node4;
		node3.right=node5;
		
		Node node = lca(root,11,10);
		
		if(node==null){
			System.out.println("Not found");
		}else{
			
			System.out.println(node.data);
		}
		
		
		
	}

	private static Node lca(Node node, int i, int j) {
		// TODO Auto-generated method stub
		if(node==null){
			return null;
		}
		
		if(node.data>i && node.data>j){
			return lca(node.left,i,j);
		}
		
		if(node.data<i && node.data<j){
			return lca(node.right,i,j);
		}
		
		return node;

	}
	
	
	
	
	

}
class Node{
	
	Node left,right;
	int data;
	
	Node(int data){
		this.data=data;
		this.left=null;
		this.right=null;
	}
	
}