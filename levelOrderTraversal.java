import java.util.LinkedList;
import java.util.Queue;

public class levelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Treenode root= new Treenode(10);
		root.left = new Treenode(-10);
	    root.right = new Treenode(19);
	    root.left.left = new Treenode(-20);
	    root.left.right = new Treenode(0);
	    root.right.left = new Treenode(17);
	    
	    levelOrderTraversal(root);

	    

	}

	private static void levelOrderTraversal(Treenode root) {
		// TODO Auto-generated method stub
		
		Queue<Treenode> queue = new LinkedList<Treenode>();
		
		queue.add(root);
		
		
		while(!queue.isEmpty()){
			root =queue.poll();
			
			System.out.println(root.data);
			if(root.left!=null){
				queue.add(root.left);
			}
			
			if(root.right!=null){
				queue.add(root.right);
			}

		}
		
	}

}
