package linkList;

public class Insertion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node node1= new Node(3);
		Node node2= new Node(5);
		Node node3= new Node(4);
		Node node4= new Node(2);
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		int position=1;
		Node head= node1;
		 Node  newNode=new Node(10);
		    Node  temp=head;
		    newNode.next=null;
		    
		    if(position ==0){
		        
		        if(head==null){
		            
		            head=newNode;
		        }else{
		            
		            newNode.next=head;
		            head=newNode;
		        }
		        
		    }else{
		        
		        for(int i=0;i<position-1;i++){
		            temp=temp.next;
		            
		        }
		        
		        newNode.next=temp.next;
		        temp.next=newNode;
		    }
		    
		    printNode(head);
		    
	}

public static void printNode(Node temp){
	while(temp!=null){
		System.out.println(temp.data);
		temp=temp.next;
		
	}
}
}

 