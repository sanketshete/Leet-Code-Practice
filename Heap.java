package linkList;

import java.util.ArrayList;

public class Heap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] heap={4,2,3,1,0,6};
		
		int child= heap.length-1;
		int root=0;
		if(child%2==0){
			root=(child-2)/2;
		}else{
			root=(child-1)/2;
		}
		
		floatup(child,root,heap);
		
		for(int i=0;i<heap.length;i++){
			System.out.println(heap[i]);
		}
	}

	private static void floatup(int child, int root, int[] heap) {
		// TODO Auto-generated method stub
		if(root<0){
			return;
		}
		
		if(heap[child]>heap[root]){
			int temp=heap[child];
			heap[child]=heap[root];
			heap[root]=temp;
			child=root;
			if(child%2==0){
				root=(child-2)/2;
			}else{
				root=(child-1)/2;
			}
			floatup(child,root,heap);
		}
		
	}

}
