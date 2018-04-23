import java.util.ArrayList;
import java.util.List;

public class PalindromPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String[] words={"abcd", "dcba", "lls", "s", "sssll"};
		List<List<Integer>> list = new ArrayList<List<Integer>>(); 
		for(int i=0;i<words.length;i++){
			for(int j=0;j<words.length;j++){
				
				if(i!=j){
					String s = words[i]+words[j];
					if(checkpalindrom(s)){
						List<Integer> list1=new ArrayList<>();
						list1.add(i);
						list1.add(j);
						list.add(list1);
						System.out.print(i +""+ j);
						System.out.println();
					}
				}
				
			}
			
		}
	}
	
	public static boolean checkpalindrom(String s1){
		
		int i=0;
		int j=s1.length()-1;
		while(i<j){
			
			if(s1.charAt(i)!=s1.charAt(j)){
				
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
	

}