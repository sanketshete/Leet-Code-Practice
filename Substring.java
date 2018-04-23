
public class Substring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] matrix= {{0},{1}};
		boolean fr=false,fc=false;

for(int i=0;i<matrix.length;i++){
	for(int j=0;j<matrix[0].length;j++){
		if(matrix[i][j]==0){
			if(i==0){
				fr=true;
			}
			if(j==0){
				fc=true;
			}
			matrix[0][j]=0;
			matrix[i][0]=0;
		}
	}
	
}

for(int i=1;i<matrix.length;i++){
	for(int j=1;j<matrix[0].length;j++){	
		if(matrix[i][0] ==0 || matrix[0][j]==0){
			matrix[i][j]=0;
		}
	}
}

	if(fr==true){
	for(int i=0;i<matrix.length;i++){
	matrix[0][i]=0;	
	}
	}

	if(fc==true){
		for(int i=0;i<matrix[0].length;i++){
			matrix[i][0]=0;	
			}	
	}
for(int i=0;i<matrix.length;i++){
	for(int j=0;j<matrix[0].length;j++){
System.out.print(matrix[i][j]);
	}
	System.out.println("");	
}
	
	
	}

}
