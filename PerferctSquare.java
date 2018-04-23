import java.util.ArrayList;
import java.util.List;

public class PerferctSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n=14;
		int last=-1;
		int arr[] = new int[n];
//		List<Integer> list = new ArrayList<Integer>();
		for(int i=1;(i*i)<n;i++){
	//		list.add(i*i);
			arr[i*i]++;
			last=i*i;
		}
		
		System.out.println(findNumber(n,arr,last,0));
	}

	private static int findNumber(int n, int[] arr,int last,int count) {
		
		if(n==0){
			return count;
		}
		if(arr[n]==1){
			return count;
		}
		return findNumber(n-last, arr, last,++count);
		
		
	}

	private static int findNumber(int n, List<Integer> list , int pointer) {

		if(pointer<0){
			return 0;
		}
		if(n-list.get(pointer)==0){
			return (list.size()-pointer);
			
		}		
			return findNumber(n-list.get(pointer), list, --pointer);
			


		
	}

}
