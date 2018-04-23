import java.util.HashMap;

public class Anagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s ="hhpddlnnsjfoyxpciioigvjqzfbpllssuj";
		int noOfChange=0;
	
		
		if(s.length()%2!=0){
			
			noOfChange=-1;
			
		}else{
			
			String sub1=s.substring(0, (s.length()/2));
			String sub2=s.substring((s.length()/2), (s.length()));
			HashMap<Character, Integer>map = new HashMap<Character,Integer>();
			
			for(int i=0;i<sub1.length();i++){
				if(map.containsKey(sub1.charAt(i))){
					
					int count =map.get(sub1.charAt(i));
					count++;
					map.put(sub1.charAt(i), count);
					
				}else{					
					map.put(sub1.charAt(i), 1);
				}
				
			}
			
			System.out.println(sub1);
			System.out.println(sub2);
			for(int i=0;i<map.size();i++){
			
				if(map.containsKey(sub2.charAt(i))){
					int count =map.get(sub2.charAt(i));
					count--;
					if(count<0){
						noOfChange++;
					}
					map.put(sub2.charAt(i), count);
					
				}else{
					noOfChange++;
					
				}
				
			}
		}
		
		System.out.println(noOfChange);
		

	}

}
