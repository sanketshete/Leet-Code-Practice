
public class VerticalHeight {

	public static void main(String[] args) {

		Treenode root= new Treenode(7);
		root.left = new Treenode(6);
	    root.right = new Treenode(5);
	    root.left.left = new Treenode(4);
	    root.left.left.left= new Treenode(3);
	    root.left.right = new Treenode(3);
	    root.right.left = new Treenode(2);
	    root.right.right = new Treenode(1);
	    
	  int verticalHeight=  getHeight(root);
	  System.out.println(verticalHeight);
		
		
	}

	private static int getHeight(Treenode root) {
	
		Treenode temp=root;
		Treenode temp1=root;
		
		int count=0;
		
		while(temp!=null){
			count++;
			temp=temp.left;
		}
		count--;
		while(temp1!=null){
			count++;
			temp1=temp1.right;
		}
		
		return count;
		
	}

}



class Treenode{
	int data;
	Treenode left,right;
	
	public Treenode(int data) {
		// TODO Auto-generated constructor stub
		this.data=data;
	}
	
}
