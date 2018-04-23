import java.util.Stack;

public class InorderSuccesor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Treenode root= new Treenode(1);
		root.left = new Treenode(2);
	    root.right = new Treenode(3);
	    root.left.left = new Treenode(4);
	    root.left.right = new Treenode(5);
	    
	    InOrder(root);
	    
	}

	private static void InOrder(Treenode root) {
		Stack<Treenode> stack = new Stack<Treenode>();
	
		boolean findElement=false;
		
		while(true){
			
			if(findElement){
				System.out.println(root.data);
				return;
			}
			if(root!=null){
				stack.push(root);
				root=root.left;
			}else{
				
				if(!stack.isEmpty()){
					root =(Treenode) stack.pop();
					if(root.data==1){
						findElement=true;
					}
					//System.out.println(root.data);
					root=root.right;
				}else{
					
					return;
				}
				
				
			}
			
		}
		

		
	}

}
