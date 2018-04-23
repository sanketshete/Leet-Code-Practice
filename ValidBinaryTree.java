import java.util.Stack;

public class ValidBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Treenode root= new Treenode(10);
		root.left = new Treenode(-10);
	    root.right = new Treenode(19);
	    root.left.left = new Treenode(-20);
	    root.left.right = new Treenode(0);
	    root.right.left = new Treenode(17);
	    
	   boolean count=IsValidBST(root,-1000,1000);
	    System.out.println(count);

	}

	private static boolean IsValidBST(Treenode root, int lower, int upper) {
		
		if(root ==  null){
			
			return true;
		}
		if(root.data<=lower || root.data>upper){
			return false;
		}
		
		return IsValidBST(root.left, lower, root.data)
				&& IsValidBST(root.right, root.data, upper);
		
	}

}
