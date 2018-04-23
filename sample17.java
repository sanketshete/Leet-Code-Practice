import java.util.ArrayList;
import java.util.List;

public class sample17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [][]Array= {{ 1, 2, 3,4 },{ 4, 5, 6,4 },{ 7, 8, 9,4 }};

		List<Integer> list = new ArrayList<Integer>();
		if(Array.length==0){
			
		}
		System.out.println(Array.length);
		System.out.println(Array[0].length);


		
int rowbegin=0,colbegin=0,rowend=Array.length-1,colend=Array[0].length-1;


	while(rowbegin<=rowend && colbegin<=colend){
	
		for(int i=colbegin;i<=colend;i++){
			list.add(Array[rowbegin][i]);
		}
		rowbegin++;
		
		for(int i=rowbegin;i<=rowend;i++){
			
			list.add(Array[i][colend]);
		}
		
		colend--;
		
		for(int i=colend;i>=colbegin;i--){
			
			list.add(Array[rowend][i]);
		}
		rowend--;
		
		for(int i=rowend;i>=rowbegin;i--){
			list.add(Array[i][colbegin]);
		}
		
		colbegin++;
	}
	
	for(int i=0;i<list.size();i++){
		
		System.out.println(list.get(i));
	}


}
}
