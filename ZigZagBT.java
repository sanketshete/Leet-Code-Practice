import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class ZigZagBT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Treenode root= new Treenode(3);
		root.left = new Treenode(9);
	    root.right = new Treenode(20);
	    root.right.left = new Treenode(15);
	    root.right.right = new Treenode(7);
	    
	    zigZagBT(root);
	    
	    
	    
	}

	private static void zigZagBT(Treenode root) {
		// TODO Auto-generated method stub
		
	List<List<Integer>> list = new ArrayList<List<Integer>>();
		
		Queue<Treenode> queue = new LinkedList<Treenode>();
		
		boolean forward=false;
		
		queue.add(root);
		queue.add(null);
		
		List<Integer> sublist = new ArrayList<Integer>();
		
		while(!queue.isEmpty()){
			
			root= queue.poll();
			if(root==null){
				if(forward){
				forward=false;
				}else{
				forward=true;	
					
				}
				list.add(sublist);
				sublist=  new ArrayList<Integer>();
			}else{
				
			sublist.add(root.data);
			if(forward){
				if(root.left!=null){
					
					queue.add(root.left);
					
				}
				if(root.right!=null){
					queue.add(root.right);
				}				
				
			}else{
				
				if(root.right!=null){
					queue.add(root.right);
				}


				if(root.left!=null){
					
					queue.add(root.left);
					
				}
				
			}
			
			queue.add(null);
		}
	}
		
		
		for(int i=0;i<list.size();i++){
			
			if(list.get(i).isEmpty()){
				list.remove(i);
			}
		}
		
	
	}

}
