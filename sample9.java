
public class sample9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="ABC";
		int numrow=3;
		StringBuilder []sarry= new StringBuilder[numrow];
		int j=1;
		int k=0;
		boolean flag=true;
		StringBuilder news= new StringBuilder();
		for(int i=0;i<numrow;i++){
			sarry[i]=new StringBuilder();
		}
		while(k<s.length()){
			if(flag==true){
				for(int i=0;i<numrow;i++){
					if(k>=s.length()){
						break;
					}
					sarry[i].append(s.charAt(k));
					k++;
				}
				flag=false;
			}else{
				j=1;
				while(j<numrow){
					if(k>=s.length()){
						break;
					}
					sarry[j].append(s.charAt(k));
					k++;				
				j=j+2;
				}
				flag=true;
			}			
			
		}
		
		for(int i=0;i<numrow;i++){
		news.append(sarry[i]);	
		}
	System.out.println(news);	
	}

}
