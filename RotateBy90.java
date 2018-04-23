
public class RotateBy90 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [][] array = {{1,2,3},{4,5,6,},{7,8,9}};
		int[][] array2= new int[array.length][array[0].length];

		int rowCount=0;
		int colCount=0;
	

		for(int i=0;i<array.length;i++){
			
			for(int j=0;j<array[0].length;j++){
				int newRow=0;
				int newCol=0;
				if(i==j){
					newRow=i;
					newCol=j;
					
				}else if((i==0 && j==array[0].length-1)){
					newRow=0;
					newCol=0;					
					
				}else if((i==0 && j==0)){
				newRow=array.length-1;
				newCol=0;
				}else if((i==array.length-1 && j==0)){
					newRow=array.length-1;
					newCol=array[0].length-1;

				}else if((i==array.length-1 && j==array[0].length-1)){
					newRow=0;
					newCol=array[0].length-1;
				}else{
				if(((i+1)<array.length) && ((j-1)>=0)){
					newRow=i+1;
					newCol=j-1;
				}else if(((i+1)<array.length) && ((j+1)<array[0].length)){
					newRow=i+1;
					newCol=j+1;
				}else if(((i-1)>=0) && ((j+1)<array[0].length)){
					newRow=i-1;
					newCol=j+1;
				}else if(((i-1)>=0) && ((j-1)>=0)){
					newRow=i-1;
					newCol=j-1;
					}
				}
				
				array2[newRow][newCol]=array[i][j];
			}
		}
		
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array[0].length;j++){
				System.out.print(array2[i][j]);
			}
			System.out.println();
		}
		
	}

}
