package linkList;

public class RemoveDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node node1= new Node(1);
		Node node2= new Node(1);
		Node node3= new Node(3);
		Node node4= new Node(3);
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		Node head= node1;
		Node temp=head;
		 if(head==null || head.next==null) return head;
		    Node root = head;
		    while(head.next!=null){
		       if(head.data!=head.next.data){
		           head = head.next;
		       }else{
		           head.next = head.next.next;
		       }
		    }
		    return root;
	}

}
