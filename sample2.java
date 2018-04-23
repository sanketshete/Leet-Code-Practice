import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class sample2 {
	
	public static void main(String[] argrs) {

	Scanner sc= new Scanner(System.in);
	int []num = {3,2,4};
	int target=6;
	int []result=new int[2];
	Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	
	for(int i=0;i<num.length;i++){
		if(map.containsKey(target-num[i])){
			result[1]=map.get(target-num[i]);
			result[0]=i;
			System.out.println(result[0]);
			System.out.println(result[1]);
			break;
		}
		map.put(num[i], i);
	}
	
	
	
	

	}
	
}
