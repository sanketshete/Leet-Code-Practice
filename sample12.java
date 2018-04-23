import java.util.ArrayList;
import java.util.List;

public class sample12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s="barfoofoobarthefoobarman";
		String []words={"bar","foo","the"};
		
		List<Integer> list = new ArrayList<Integer>();
		int j=0;
		for(int i=0;i<words.length;i++){
			String news1=words[i];
			String news=words[i];
			for(j=0;j<words.length;j++){
				
				if(i!=j){
					
					 news=news+words[j];
				}				
			}
			for(int k=words.length-1;k>=0;k--){
				
				if(i!=k){
					
					 news1=news1+words[k];
				}
							
			}

			System.out.println(news);
			System.out.println(news1);
			if(s.indexOf(news)>=0){
					list.add(s.indexOf(news));
				}	
			if(!(news.contentEquals(news1)) && s.indexOf(news1)>=0){
				list.add(s.indexOf(news1));
				}
			
			}
		System.out.println(list);
		
	}
}

	


