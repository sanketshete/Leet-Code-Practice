package linkList;


class Node {
    int data;
    Node next;
    
    Node(int data){
    	
    	this.data = data;
    	this.next=null;
    }
 }

public class PrintLinklist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node node1= new Node(3);
		Node node2= new Node(4);
		Node node3= new Node(5);
		Node node4= new Node(6);
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		
		Node head= node1;
		Node temp=head;
		while(temp!=null){
			System.out.println(temp.data);
			temp=temp.next;
			
		}
		
	}

}
