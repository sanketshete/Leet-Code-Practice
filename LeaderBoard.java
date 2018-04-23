import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LeaderBoard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer[] scores ={100,100,50,40,40,20,10};
		Integer [] alice={5,25,50,120};
		int rank[] = new int[alice.length];
		int totalcount=0;
		
		/*
		 * right program
	
		 *  int[] array = of(scores).distinct().toArray();
    int i = array.length-1;
    for(int score: alice) {
        while(i>=0) {
            if(score>=array[i]) i--;
            else {System.out.println(i+2); break;}
        }
        if(i<0) System.out.println(1);
    }
		 * 
		 */
		int i=scores.length-1;
		for(int j=0;j<alice.length;j++){
			int count=i;
			while(i>=0){
				if((scores[i]>alice[j]) ||(scores[i]==alice[j])){
					System.out.println(count);
					rank[j]=count;
					break;
				}else if((scores[i]<alice[j]) && i==0){
					rank[j]=1;
					System.out.println(rank[j]);
					break;
				}else{
				count--;
				totalcount++;
				}
				i--;
			}
		}
		
		/*
		List<Integer> list= new ArrayList<Integer>();

		TreeMap<Integer, Integer> map = new TreeMap<Integer,Integer>();
		
		for(int i=0;i<scores.length;i++){
			map.put(scores[i],i);
		}
		
		
		for(int i=0;i<alice.length;i++){
			map.put(alice[i],i);
			int count=0;
			for(Map.Entry<Integer, Integer> entry: map.entrySet()){
				if(entry.getKey() == alice[i]){
					System.out.println(map.size()-count);
				}
				count++;
			
			}
			map.remove(alice[i]);
		}
		System.out.println(map);*/
	}

}
