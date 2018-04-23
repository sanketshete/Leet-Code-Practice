import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoveDuplicates1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		List<Integer> list=new ArrayList<Integer>();
		List<Integer> Olist=new ArrayList<Integer>();
		
		list.add(1);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(3);
		
		Map<Integer, Integer> map= new HashMap<Integer,Integer>(); 
		
		for(int i=0;i<list.size();i++){
			if(!map.containsKey(list.get(i))){
				map.put(list.get(i),0);
				Olist.add(list.get(i));
			}			
		}
		
		for(int i=0;i<Olist.size();i++){
			
			System.out.println(Olist.get(i));
		}
		
		
	}

}
