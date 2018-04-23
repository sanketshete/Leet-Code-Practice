
public class HeightOfTree {

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
		
		
		
		System.out.println(height(root));

	}

	private static int height(Node root){
		
		if(root==null){
			return 0;
		}else{
			
			int ldepth=height(root.left);
			int rheight=height(root.right);
			
			if(ldepth>rheight){
				return(ldepth+1);
			}else{
				return (rheight+1);
			}
		}
		
	}
	
}
