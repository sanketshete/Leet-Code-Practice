
public class JumLength {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums={2,3,1,1,4};
		
		int i=0;
		int jumpLength=0;
		
		boolean var =funct(nums);
		System.out.println(var);
		
	}

	private static boolean funct(int[] nums) {
		// TODO Auto-generated method stub
   		int i=0;
	int jumpLength=0;
	
    if(nums.length==1){
        return true;
    }
		while(i<nums.length){

        if(nums[i]==0){
			return false;
		}
	    	i=i+nums[i];

		if(i==(nums.length-1)){
			return true;
		}else if(i>=nums.length){
            return true;
        }			
	}
		return false;
	}

}
