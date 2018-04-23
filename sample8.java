import java.util.ArrayList;

public class sample8 {

	public static void main(String[] args) {

		int []nums={3,4,-1,1};
		int []nums1= new int[nums.length];
		for(int i=0;i<nums.length;i++){
		
			if(nums[i]<=0 || nums[i]>=nums.length || nums[i]==i){
			}else{
				nums1[nums[i]]=nums[i];
			}
		}
		
		int flag=0;
		for(int i=1;i<nums1.length;i++){
			if(nums1[i]==0){
				flag=1;
				System.out.println(i);
				break;
			}
		}
		if(flag==0){
			System.out.println(nums1[nums1.length-1]+1);
		}
		
	}

}
