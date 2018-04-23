
public class PartitionsList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode1 node1= new ListNode1(1);
		ListNode1 head=node1;
		ListNode1 node2= new ListNode1(4);
		node1.next=node2;
		ListNode1 node3= new ListNode1(3);
		node2.next=node3;
		ListNode1 node4= new ListNode1(2);
		node3.next=node4;
		ListNode1 node5= new ListNode1(5);
		node4.next=node5;
		ListNode1 node6= new ListNode1(2);
		node5.next=node6;
		
		int n=3;
		
		ListNode1 temp1=null;
		ListNode1 temp2=null;
		ListNode1 temp3=head;
		ListNode1 head2 = null,head3=null;
/*		while(temp4!=null){
			System.out.println(temp4.val);
			temp4=temp4.next;
		}
*/

		while(temp3!=null){
			
			if(temp3.val>=3){
				if(temp1==null){
					temp1=temp3;
					if(head2==null){
						head2=temp1;
					}
				}else{
					temp1.next=temp3;
					temp1=temp3;
				}
				
			}else{
				if(temp2==null){
					temp2=temp3;
					if(head3==null){
						head3=temp2;
					}
				}else{
					temp2.next=temp3;
					temp2=temp3;
				}
			}
			temp3=temp3.next;
		}
		
		temp2.next=head2;
		temp1.next=null;
		temp3=head3;
		while(temp3!=null){
			System.out.println(temp3.val);
			temp3=temp3.next;
		}
		
	}

}

 class ListNode1 {
     int val;
     ListNode1 next;
     ListNode1(int x) { val = x; }
 }