import java.util.Stack;

public class ConstructBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int arr[] = {7, 4, 12, 3, 6, 8, 1, 5, 10};

		Treenode root= new Treenode(7);
		Treenode temp=root;
		Treenode parent=root;
		for(int i=1;i<arr.length;i++){
			temp=root;
			parent=root;
			
			Character dir = null;
			while(temp!=null){	
				
			if(arr[i]>=temp.data){
			parent=temp;	
			temp=temp.right;	
			dir='r';
				
			}
			else{
				parent=temp;
				temp=temp.left;
				dir='l';
				}
			}
			
			Treenode temp2= new Treenode(arr[i]);
			
			if(dir=='r'){
				
				parent.right=temp2;
			}else if(dir=='l'){
				parent.left=temp2;
			}
			
		}
		
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
