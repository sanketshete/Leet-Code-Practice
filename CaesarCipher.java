
public class CaesarCipher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s ="middle-Outz";
		String output="";
		int k=2;

		
		for(int i=0;i<s.length();i++){
		
			int char1=(int)s.charAt(i);
			
			if(char1>=97 && char1<=122){
			
			if((char1+k)>122){
				output=output+(char)(((char1+k)%122)+96);
				
			}else if((char1+k)==122){
				output=output+(char)((char1+k));
			}else{
				output=output+(char)((char1+k)%122);
			}
			}else if(char1>=65 && char1<=90){
				if((char1+k)>90){
					output=output+(char)(((char1+k)%90)+64);
					
				}else if((char1+k)==90){
					output=output+(char)((char1+k));
				}else{
					output=output+(char)((char1+k)%90);
				}
				
				
			}else{
				
				output=output+(char)(char1);
			}
			//System.out.println(char1);
			//output=output+ (char)(((char1+k)%122)+97);
			
		}
		System.out.println(output);
		
		
		
	
	}
	
	

}
