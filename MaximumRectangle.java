
public class MaximumRectangle {

	public static void main(String[] args) {

		int[][]matrix={{0,1,1,1,0},{1,1,1,1,1},{0,1,1,1,1},{0,1,1,1,1},{0,0,1,1,1}};
		
		int [] colmn=new int[matrix[0].length];
		
		for(int i=0;i<matrix.length;i++){
			
			for(int j=0;j<matrix[0].length;j++){
				
				colmn[j]=colmn[j]+matrix[i][j];
			}
			int maxArea = findMaxArea(colmn);
		}
	}

	private static int findMaxArea(int[] colmn) {
	
		
		return 0;
	}

}
