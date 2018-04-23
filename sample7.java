import java.util.Comparator;
import java.util.PriorityQueue;

public class sample7 {

	
	class customer {
		
		int a;
		String name;
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Comparator<customer> idcomparator = new Comparator<sample7.customer>() {

			@Override
			public int compare(customer o1, customer o2) {
				return (int) (o1.a-o2.a);
			}
			
		};
		PriorityQueue<customer> queue = new PriorityQueue<>(8, idcomparator);
		
	}

}
