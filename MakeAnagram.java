import java.util.HashMap;

public class MakeAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s1="cde";
		String s2="abc";
		int result=0;
		
		
		int cs1[]= new int[26];
		int cs2[]= new int[26];
		
		
		for(int i=0;i<s1.length();i++){
		cs1[(int)s1.charAt(i)-97]++;
		}
		
		for(int i=0;i<s2.length();i++){
		cs2[(int)s2.charAt(i)-97]++;
		}
		
		
		for(int i=0;i<26;i++){
			result=result+Math.abs(cs1[i]-cs2[i]);
		}
		System.out.println(result);
	}

}
