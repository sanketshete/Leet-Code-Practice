
public class birthdayProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int []ar= {3,2,1,3};
		int n=4;
		int max=0;
		int count=0;
		int [][]a= new int[2][2];
		
		
		for(int i=0;i<n;i++){    
            if(max<ar[i]){
                max=ar[i];
            }else if(max==ar[i]){
             count++;   
            }else{
            	count=0;
            }
        }
        System.out.println(count+1);
		
	}

}
