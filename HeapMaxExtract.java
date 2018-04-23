package linkList;

public class HeapMaxExtract {

	public static void main(String[] args) {
		int [] heap={4,2,3,1,0};
		
		int temp=heap[heap.length-1];
		heap[heap.length-1]=heap[0];
		heap[0]=temp;
		
		floatup(0,heap.length-1,heap);
		
		for(int i=0;i<heap.length-1;i++){
			System.out.println(heap[i]);
		}

		
		
	}
	private static void floatup(int i, int heapLength, int[] heap) {
		// TODO Auto-generated method stu
		
		int left=(i*2)+1;
		int right=(i*2)+2;
		int largest=-1;
		if(left<=heapLength && heap[left]>heap[i]){
			largest=left;			
		}else{	
			largest=i;
		}
		if(right<=heapLength && heap[right]>heap[i]){
			largest=right;
		}
		if(largest!=i){
			int temp=heap[largest];
			heap[largest]=heap[i];
			heap[i]=temp;
			floatup(largest,heapLength,heap);
		}

		}
}
