import java.util.HashMap;
import java.util.Map;

public class sample15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][]A = new int[7][3];
				A[0][0] = 5;    A[0][1] = 4;    A[0][2] = 4;
				A[1][0] = 4;    A[1][1] = 3;    A[1][2] = 4;
				A[2][0] = 3;    A[2][1] = 2;    A[2][2] = 4;
				A[3][0] = 2;    A[3][1] = 2;    A[3][2] = 2;
				A[4][0] = 3;    A[4][1] = 3 ;   A[4][2] = 4;
				A[5][0] = 1;    A[5][1] = 4  ;  A[5][2] = 4;
				A[6][0] = 4;    A[6][1] = 1   ; A[6][2] = 1;
		
int numberofCountrie=0;
Map<Integer,Integer> map=new HashMap<Integer,Integer>();
	for(int i=0;i<A.length;i++){
		
	for(int j=0;j<A[0].length;j++){
		if(i==3 && j==2){
			System.out.println("");
		}
		if(!map.containsKey(A[i][j])){
			numberofCountrie++;
			map.put(A[i][j], 0);
		}else{
			int newi=i-1;
			int newj=j-1;			
			//int newi1=i+1;
			//int newj1=j+1;
			
			int flag=0;
			if(newi>=0){
				if(A[newi][j] ==A[i][j]){
					flag=1;
				}
			}
			if(newj>=0){
				if(A[i][newj] == A[i][j]){
					flag=1;
					}
								
			}/*else if(newi1<A.length){
				if(A[newi1][j]==A[i][j]){
					flag=1;
				}
				
			}else if(newj1<A[0].length){
				
				if(A[i][newj1]==A[i][j]){
					flag=1;
				}
			}*/
			
			if(flag==0){
				numberofCountrie++;
			}
		}
	
	}

	}
	System.out.println(numberofCountrie);
}
}
