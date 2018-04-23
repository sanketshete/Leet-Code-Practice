import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SherlockString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s="aabbcc";
		
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		
		
		for(int i=0;i<s.length();i++)
		{
			if(map.containsKey(s.charAt(i))){
				int count =map.get(s.charAt(i));
				count++;
				map.put(s.charAt(i),count);
			}else{
				map.put(s.charAt(i), 1);
			}
		}
		
		int prevCount=0;
		int falsecount=0;
		Set<Integer> set = new HashSet<Integer>();
		for(Map.Entry<Character, Integer> entry : map.entrySet()){
			set.add(entry.getValue());
			if(prevCount!=0 && entry.getValue()==prevCount){
				
				
			}else if(Math.abs(entry.getValue()-prevCount)==1){
				falsecount++;
				if(falsecount>1){
					
				}
			}
			prevCount=entry.getValue();
		}

		if(s.length()>2){
			
		}else if(s.length()==2){
			
		}
		
		
	}

}
