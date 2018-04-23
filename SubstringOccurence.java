
public class SubstringOccurence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s= "GoogleisAwesome";
		String x="isA";
		int startIndex=-1;
		int j=0;
		for(int i=0;i<s.length();i++){
			if(j==x.length()){
				startIndex=i-(x.length()-1);
				break;
			}
			if(x.charAt(j)==s.charAt(i)){
				j++;
			}else{
				j=0;
			}
			
		}
		System.out.println(startIndex-1);
	}

}
