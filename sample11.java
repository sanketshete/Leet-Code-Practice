

public class sample11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ListNode head = new ListNode(1);
		ListNode node1 = new ListNode(2);
		head.next=node1;
		node1.next=null;
//		ListNode node2 = new ListNode(3);
//		node1.next=node2;
//		int n=1;
//		ListNode node3 = new ListNode(4);
//		node2.next=node3;
//		node3.next=null;
//		head.next=null;
		int n=2;
		  
		if(head.next==null && n==1){
            head=head.next;
        }else{

       ListNode slow=head,fast=head;
        
        for(int i=0;i<n;i++){
            fast=fast.next;
        }
       
        if(fast==null){
        	head=head.next;
        	
        }
        while(fast!=null && fast.next!=null){	            
            fast=fast.next;
            slow=slow.next;
        }
        
        slow.next=slow.next.next;
    }
		
	        while(head!=null){
	        	System.out.println(head.val);
	        	head=head.next;
	        	}
	        }
	

}
