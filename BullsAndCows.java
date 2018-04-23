
public class BullsAndCows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String secreat="1231";
		String guess ="0110";

		int bulls=0;
		int cows=0;
		int number[]= new int[10];
		
		for(int i=0;i<secreat.length();i++){
			
			if(guess.charAt(i)==secreat.charAt(i)){
				bulls++;
				
			}else{
				int g=Character.getNumericValue(guess.charAt(i));
				int s=Character.getNumericValue(secreat.charAt(i));
				

				if(number[s]<0){
					cows++;
				}
				if(number[g]>0){
					cows++;
				}
				
				number[s]++;
				number[g]--;
				
			}
			
			
		}
		
		
		
		
		String output= bulls+"A"+cows+"B";
		
		System.out.println(output);
		
		

	}

}
