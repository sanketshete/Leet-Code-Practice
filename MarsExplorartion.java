
public class MarsExplorartion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s="SOSSPSSQSSOR";
		String sub ="SOS";
		
		int differentChar=0;
		int count=0;		
		for(int i=0;i<s.length();i++){
						
				if((sub.charAt(i%3)!=s.charAt(i))){
					differentChar++;
				}
			
		}
		System.out.println(differentChar);

	}

}
