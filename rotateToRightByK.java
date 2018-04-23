
public class rotateToRightByK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode1 node1= new ListNode1(1);
		ListNode1 head=node1;
		ListNode1 node2= new ListNode1(2);
		node1.next=node2;
		ListNode1 node3= new ListNode1(3);
		node2.next=node3;
		ListNode1 node4= new ListNode1(4);
		node3.next=node4;
		ListNode1 node5= new ListNode1(5);
		node4.next=node5;
		
		int k=2;
		
		
		 ListNode1 temp=head;
         ListNode1 temp1=head;
 
		 int sizeOfList=0; 
		 while(temp.next!=null){
		     temp=temp.next;
		     sizeOfList++;
		 }
		 
	     sizeOfList++;
		 temp.next=head;
		 
		 int rotation = sizeOfList-k;
		 System.out.println(sizeOfList);
		 int rot1=1;
		 while(rot1!=rotation){
		      temp1=temp1.next;
		         rot1++;
		 }
		 
		 head=temp1.next;
		temp1.next=null;
		
		
		while(head!=null){
			
			System.out.println(head.val);
			head=head.next;
		}
		 
		
	}

}


