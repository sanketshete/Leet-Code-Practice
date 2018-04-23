
public class sample13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		String str = "KJHGJGJKGHKJBK654654kjgjugjjhbkjnmlkljhkjl";
		int length=-1;
		int prev=-1;
		String [] Str = str.split("[^A-Za-z0-9]+|(?<=[a-zA-Z])(?=[0-9])|(?<=[0-9])(?=[a-zA-Z])");
		for(String s : Str) {
//			System.out.println(s);
			
			boolean hasUcase = !s.equals(s.toLowerCase());
			if(!(s.matches(".*\\d.*"))  && hasUcase){

				prev =s.length();
				if(length<prev){
					length=prev;
				}
			}
			
		}
		
		System.out.println(length);

	}

}
