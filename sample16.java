
public class sample16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String num1="0";
		String num2="0";
		
		int []pos= new int[num1.length()+num2.length()];
		
	for(int i=num1.length()-1;i>=0;i--){
		
		for(int j=num2.length()-1;j>=0;j--){
			int mul=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
			
			int p1=i+j;
			int p2=i+j+1;
			int sum=pos[p2]+mul;
			int div=sum/10;
			pos[p1]=pos[p1]+div;
			int rem=sum%10;
			pos[p2]=pos[p2]+rem;
			
		}
		
	}
	StringBuilder sb = new StringBuilder();
	for(int i:pos){
		sb.append(i);
	}
	
	if(num1=="0"){

		System.out.println(0);
	}
	if(num2=="0"){
System.out.println(0);
	}
	
System.out.println(sb.toString());
	
	}

}
