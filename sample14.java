import java.util.HashMap;
import java.util.Map;

public class sample14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] A=new int[3];
		int[] B=new int[3];
		int X=2;
		int Y=200;
		int M=5;
		
		A[0] =60;				B[0] =2;
			    A[1] =  80;   B[1] = 3;
			    A[2] = 40;B[2] = 5;
			    
			    int tracknumber=0;
			    int stepsnumber=0;
	
		while(tracknumber<A.length){
			int numofpeo=0;
			int weightsum=0;
			int floornumber=0;
			  Map<Integer,Integer> map=new HashMap<Integer,Integer>();
			  while(numofpeo<X && weightsum<Y && tracknumber<A.length){
				if(!map.containsKey(B[tracknumber])){
					map.put(B[tracknumber], 0);  
					stepsnumber++;
					}

				/*if(B[tracknumber]==floornumber){
				}else{
					stepsnumber++;
				}*/
				numofpeo++;
				weightsum=weightsum+A[tracknumber];
				floornumber=B[tracknumber];
				tracknumber++;
			}
			if(weightsum>Y || numofpeo>X){
				tracknumber--;
			}
			stepsnumber++;
		}
			System.out.println(stepsnumber);    
	}
	

}
