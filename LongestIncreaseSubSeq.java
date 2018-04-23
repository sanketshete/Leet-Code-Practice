
public class LongestIncreaseSubSeq {

	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub

		int [] nums= {10, 9, 2, 5, 3, 7, 101, 18};
		int currLongestLength=0;
		int longestrLength=0;
		for(int i=0;i<nums.length;i++){
			
			int num=nums[i];
			currLongestLength=0;
			for(int j=i+1;j<nums.length;j++){
				
				if(nums[j]>num){
					num=nums[j];
					currLongestLength++;
				}
			}
			
			if(longestrLength<currLongestLength){
				longestrLength=currLongestLength;
			}
			
		}
		
		System.out.println(longestrLength);
	}

}
