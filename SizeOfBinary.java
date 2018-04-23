import java.util.Stack;

public class SizeOfBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Treenode root= new Treenode(1);
		root.left = new Treenode(2);
	    root.right = new Treenode(3);
	    root.left.left = new Treenode(4);
	    root.left.right = new Treenode(5);

	    
	    int count=getSizeOfTree(root);
	    System.out.println(count);
	}

	private static int getSizeOfTree(Treenode root) {
		// TODO Auto-generated method stub
		Stack<Treenode> stack = new Stack<Treenode>();
		int count=0;
		while(true){
			
			if(root!=null){
				
				stack.push(root);
				root=root.left;
				
			}else{
				
				if(!stack.isEmpty()){
				root = stack.pop();
				//System.out.println(root.data);
				count++;
				root=root.right;
				}else{
					
					return count;
				}
			}
		}
		
	}

}
