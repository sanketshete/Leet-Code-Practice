import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class HeightOfBTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Treenode root= new Treenode(1);
		root.left = new Treenode(2);
	    root.right = new Treenode(3);
	    root.left.left = new Treenode(4);
	    root.left.left.left = new Treenode(4);
	    root.left.left.left.left = new Treenode(4);
	    root.left.right = new Treenode(5);

	    
	    int count=getHeightOfTree(root);
	    System.out.println(count);

		
	}

	private static int getHeightOfTree(Treenode root) {
		// TODO Auto-generated method stub
		
		Queue<Treenode> queue = new LinkedList<Treenode>();
		int height=0;
		queue.add(root);
		queue.add(null);
		while(!queue.isEmpty()){
			
			root=queue.poll();
			if(root==null){
				height++;
			}else{
			
			if(root.left!=null || root.right!=null){
				
				if(root.left!=null){
					queue.add(root.left);
				}
				if(root.right!=null){
					queue.add(root.right);
				}
				queue.add(null);
				
				}
			}
		}
		
		return height;

}
}
