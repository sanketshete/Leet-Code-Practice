
public class KthAncestor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Treenode root= new Treenode(1);
		root.left = new Treenode(2);
	    root.right = new Treenode(3);
	    root.left.left = new Treenode(4);
	    root.left.right = new Treenode(5);
	    
	     Treenode temp = null;
	    
	     KthAncestor(root,5,2);
	    
	}

	private static boolean  KthAncestor(Treenode root,int node,int k) {
		if (root==null)
	        return false;
	     
	    if(root.data==node){
	    	
	    	return true;
	    }
	    
	    if(KthAncestor(root.left, node, k)
	    		|| KthAncestor(root.right, node, k)){
	  
	    	System.out.println(root.data);
	    	return true;
	    }
	    
	    
	    return false;
	    
	    
		
	}

}
