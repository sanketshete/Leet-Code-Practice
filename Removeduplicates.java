
public class Removeduplicates {
public static void main(String[] args) {
	
	int []nums={1,1,1,2,2,2,2,2,3,3,3};
	 int sum=1;
	 int count=0;
	 int prev=0;
int j=0;
	 for(int i=0;i<nums.length;i++){
		if(i<2 || nums[j-2]<nums[i]){
			nums[j]=nums[i];
			j++;
			
		}
		 
	 }
	 System.out.println(j);

}
}
