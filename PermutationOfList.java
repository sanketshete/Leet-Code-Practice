import java.util.ArrayList;
import java.util.List;

public class PermutationOfList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		int[] list = {1,2,3};
		int[] count = {1,1,1};
		int[] result = new int[3];
		
		getPermutation(list,count,result,0);
		
	}

	private static void getPermutation(int[] list, int[] count,int []result,int level) {
		
		if(result.length==level){
		
			for(int i=0;i<level;i++){
				System.out.print(result[i]);
			}
			System.out.println();
			//print the result
			return;
		}
		
		for(int i=0;i<list.length;i++){
			
			if(count[i]==0){
				continue;
			}
			result[i]=list[i];
			count[i]--;
			getPermutation(list, count, result,level+1);	
			count[i]++;
		}
		
		
	}

}
