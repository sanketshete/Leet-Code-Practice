
public class sample1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	//int arr[]={1,1,2,3,3,4,4,5,5,6,6,6,7,7,8,9,9,9,9,10};
	int arr[]={1,1,1,1,1,2,3,3,3,3};	

	int mcount=0;
	int i=0;
	int Scount=0;
while(i<arr.length-1){
		int count=0;
		int j;
			for(j=i+1;j<arr.length;j++){
				
				if(arr[i]==arr[j]){
					Scount=1;
					count++;
				}else{
					i=j;
					break;
				}
				
			}
			if(j==arr.length){
				if(Scount==1){
					mcount++;
					Scount=0;
				}
				break;
				
			}
			if(Scount==1){
				mcount++;
				Scount=0;
			}
		}

System.out.println(mcount);
	}
}