
public class sample3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "pwwkew";
		String s3=s.charAt(0)+"";
		int k=0;
		String finalS=null;
		String prev=new String();
		for(int i=1;i<s.length();i++){
			
			if(s3!=null && s3.indexOf(s.charAt(i))>=0){
				k=i;
				if(prev!=null && prev.length()>s3.length()){
					finalS=prev;
				}else{
					finalS=s3;
				}
				prev=s3;
				s3=null;
				
			}else{
				s3=s.substring(k, i+1);
			}
			
		}
		
		System.out.println(finalS);
	}

}
