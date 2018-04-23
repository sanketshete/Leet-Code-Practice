import java.util.Stack;

public class PreorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Treenode root= new Treenode(10);
		root.left = new Treenode(-10);
	    root.right = new Treenode(19);
	    root.left.left = new Treenode(-20);
	    root.left.right = new Treenode(0);
	    root.right.left = new Treenode(17);
	    
	    preOrderTraversal(root);

	}

	private static void preOrderTraversal(Treenode root) {
	
		Stack<Treenode> stack = new Stack<Treenode>();

		while(true){
			
			if(root!=null){
				System.out.println(root.data);
				stack.push(root);
				root=root.left;
				
			}else{
				if(!stack.isEmpty()){
					root=stack.pop();
					root=root.right;
				}else{
					return;
				}
			}
		}
		
	}

}
