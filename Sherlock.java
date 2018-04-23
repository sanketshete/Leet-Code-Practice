import java.util.HashMap;

public class Sherlock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s= "aabbcd";
		boolean flag=true;;
		int [] chars1= new int[26];
		
		HashMap<Character, Integer> map = new HashMap<Character,Integer>();
		
		for(int i=0;i<s.length();i++){
			
			if(map.containsKey(s.charAt(i))){
				
				int count =map.get(s.charAt(i));
				count++;
				map.put(s.charAt(i), count);
				
			}else{					
				map.put(s.charAt(i), 1);
			}
			
		}
		
		
	    int max=map.get(s.charAt(0));
	    int min=map.get(s.charAt(0));
	    for(int i=1;i<s.length();i++){
	    	
	    	if(map.get(s.charAt(i))>max){
	    		max=map.get(s.charAt(i));
	    	}else if(map.get(s.charAt(i))<min){
	    		min=map.get(s.charAt(i));
	    	}
	    }
	    
		
		
		
		
		
		
		for(int i=0;i<s.length();i++){
			
			chars1[(int)s.charAt(i)-97]--;
			flag=true;
			for(int j=1;j<s.length();j++){
				
				if(j!=i){
				if((chars1[(int)s.charAt(j)-97] !=chars1[(int)s.charAt(j-1)-97])
						&& chars1[(int)s.charAt(j)-97]!=0 && chars1[(int)s.charAt(j-1)-97]!=0){
					//break;
					flag=false;
					}
				}
				
			}
			
			if(flag==true){
				System.out.println("YES");
				break;
			}
		}
		
		
		
	}

}
