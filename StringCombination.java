import java.util.ArrayList;
import java.util.List;

public class StringCombination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] input = {1,3,2,4};
		int [] count={1,1,1,1};
		int[] output = new int[input.length];
		
		printpossibleCombination(input,count,0,output,0);

	}

	private static void printpossibleCombination(int[] input, int[] count,int pos,int[] output, int len) {
		
		System.out.println(output);
		for(int i=pos;i<input.length;i++){
			if(count[i]==0){
				continue;
			}
			output[len]=input[i];
			count[i]--;
			printpossibleCombination(input, count, i, output, len+1);
			count[i]++;
		}
		
		
	}

}
