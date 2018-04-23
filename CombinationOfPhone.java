import java.util.LinkedList;

public class CombinationOfPhone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String digits="234";
		
		String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		
		
		LinkedList<String> list = new LinkedList<String>();
		list.add("");

		
		for(int i=0;i<digits.length();i++){
			
			int x= Character.getNumericValue(digits.charAt(i));
			

				
				while(list.peek().length()==i){
					
					String char1=list.remove();
					for(char c :mapping[x].toCharArray()){
						list.add(char1+c);
					}
					
				}
		}
		
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
			
		}
	}

}
