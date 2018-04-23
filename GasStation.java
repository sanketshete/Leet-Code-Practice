
public class GasStation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] gas = {5,3,4,1,0,2};
		int[] cost={5,2,5,1,0,2};
		
		
		int var =funct(gas,cost);
		
		System.out.println(var);
		


	}

	private static int funct(int[] gas, int[] cost) {
		// TODO Auto-generated method stub
		for(int i=0;i<gas.length;i++){
			int rem=0;
			for(int j=i;j<(gas.length+j);j++){
				int gasStation=j;
				if(j>=gas.length){
					gasStation=gasStation%(gas.length);
				}
				
				rem=rem+gas[gasStation]-cost[gasStation];
				if(rem<0){
					break;
				}
				if(j==((gas.length+i)-1)){
					return i;
				}
			}
			
		}
		return -1;
	}

}
