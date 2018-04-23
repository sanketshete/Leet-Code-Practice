
public class sample5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] num1={1,2};
		int [] num2={3,4};
		int []num3= new int[num1.length+num2.length];
		int i=0,j=0,k=0;
		while(i<=num1.length || j<= num2.length){
			if(j==num2.length && i==num1.length){
				break;
			}
			if(j==num2.length){
				
				num3[k]=num1[i];
				k++;
				i++;
			}else if(i==num1.length){
				num3[k]=num2[j];
				k++;
				j++;
				
			}else{
				
			if(num1[i]<num2[j]){
				num3[k]=num1[i];
				k++;
				i++;
			}else{
				num3[k]=num2[j];
				k++;
				j++;
				}
			}
		}
		float median;
		if(num3.length % 2==0){
			median=(float)(num3[num3.length/2-1]+num3[num3.length/2])/2;
			
		}else{
			median=num3[num3.length/2];
		}
		
		System.out.println(median);

	}

}
