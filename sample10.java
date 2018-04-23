
public class sample10 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode head = new ListNode(1);
		ListNode node1 = new ListNode(2);
		head.next=node1;
		ListNode node2 = new ListNode(3);
		node1.next=node2;
		
		ListNode node3 = new ListNode(4);
		node2.next=node3;
		node3.next=null;
		int flag=1;
		ListNode temp1=head;
			
	}

}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    
   public ListNode swapNode(ListNode head){
	   if(head==null || head.next==null){
		   return head;
	   }
	   ListNode n1=head.next;
	   head.next=swapNode(head.next.next);
	   n1.next=head;
	   return n1;
	   
   }
}