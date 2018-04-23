
public class sample6 {

	
	public static void main(String[] args) {
	
		String s="a0Ba";
		String prev=null;
		prev=s.charAt(0)+"";
		if(s.length()<1000){
		for(int i=0;i<s.length();i++){
			
			String news=s.substring(i+1, s.length());
			int index=s.indexOf(s.charAt(i),i+1);
			while(index >= 0) {
					if(s.substring(i, index+1).equalsIgnoreCase(new StringBuilder(s.substring(i, index+1)).reverse().toString())){
					if(prev==null){
						prev=s.substring(i, index+1);
					}else{
						if(prev.length()<s.substring(i, index+1).length()){
							prev=s.substring(i, index+1);
						}
					}
						
					}
					index = s.indexOf(s.charAt(i), index+1);
			}
						
		}
		System.out.println(prev);
		}else{
			System.out.println();
		}

		
	}
}
