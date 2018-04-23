
public class MaximumSquare {

	public static void main(String[] args) {

		int[][]matrix={{0,1,1,1,0},{1,1,1,1,1},{0,1,1,1,1},{0,1,1,1,1},{0,0,1,1,1}};
		
		int[][] matrix1= new int[matrix.length+1][matrix[0].length+1];
		
		int maxsquare=0;
		for(int i=0;i<matrix.length;i++){
			
			for(int j=0;j<matrix[0].length;j++){
				if(matrix[i][j]==1){
					
					matrix1[i+1][j+1]=Math.min(Math.min(matrix1[i][j+1], matrix1[i][j]),matrix1[i+1][j])+1;
					maxsquare=Math.max(matrix1[i+1][j+1], maxsquare);
				}
				
			}
		}
		
		System.out.println(maxsquare*maxsquare);
		
	}

}
