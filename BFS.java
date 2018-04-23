import java.util.LinkedList;
import java.util.Queue;

public class BFS {

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

		bfs(root);
	}

	private static void bfs(Node root) {

		if(root==null){
			return;
			
		}
		
		Queue<Node> queue = new LinkedList<Node>();
		
		queue.add(root);
		while(!queue.isEmpty()){
			
			Node node=queue.poll();
			System.out.println(node.data);
			
			if(node.left!=null){
				queue.add(node.left);
			}
			if(node.right!=null){
				queue.add(node.right);
			}
		}
		
		
	}
	
	


}
