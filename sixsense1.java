import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class sixsense1 {

	public static void main(String[] args) {
		

		String[] grid= new String[4];
		
		int inputSize=0;
		
		System.out.println("Enter the input grid");
		
		Scanner scanner = new Scanner (System.in);
		for(int i=0;i<4;i++){
			String input= scanner.nextLine();
			grid[i]=input;
		}
		for(int i=0;i<4;i++){
			System.out.println(grid[i]);
		}

		System.out.println("Enter the size of input");
		
		inputSize = scanner.nextInt();
		
		String[] input = new String[inputSize];
		
		System.out.println("Enter the input Strings");
		for(int i=0;i<inputSize;i++){
			input[i]=scanner.nextLine();
		}
		Map<Character,ArrayList<node>> table = new HashMap<Character,ArrayList<node>>();
		
		for(int i=65;i<=90;i++){
			table.put((char)i, null);
			
		}
		for(int i=0;i<input.length;i++){
			
			for(int k=0;k<4;k++){
			for(int j=0;j<grid.length;j++){
				
				if(grid[j].indexOf(input[i].charAt(k))!=-1){
					node node1= new node();
					node1.row=j;
					node1.col=grid[j].indexOf(input[i].charAt(k));
					table.get(input[i].charAt(k)).add(node1);
				}
				
				}
			
			}
		}
		
		WordSeek(table,input);
		
	}

	private static void WordSeek(Map<Character, ArrayList<node>> table, String[] input) {
	

		for(int i=0;i<input.length;i++){
			boolean findchar=false;
			int count=0;
			int prevRow=-1;
			int prevCol=-1;
			int size=0;
			boolean con1 = false,con2= false,con3= false,con4= false,con5= false,con6= false,con7= false,con8=false;
			for(int j=0;j<4;j++){
				
				ArrayList<node> array= table.get(input[i].charAt(j));
				for(int k=size;k<array.size();k++){
					
					if(j==0){
					prevCol=array.get(k).col;
					prevRow = array.get(k).row;
					count++;
					break;
					}
					else if((prevCol==array.get(k).col-1 && prevRow == array.get(k).row-1) && (con1 || j==1))
					{
						prevCol=array.get(k).col;
						prevRow = array.get(k).row;
						con1=true;
						count++;
						break;
					}
					else if(prevCol==array.get(k).col && prevRow == array.get(k).row-1 && (con2 || j==1)){
						prevCol=array.get(k).col;
						prevRow = array.get(k).row;
						con2=true;
						count++;
						break;
					}
					else if  (prevCol==array.get(k).col+1 && prevRow == array.get(k).row-1 && (con3 || j==1)){
						prevCol=array.get(k).col;
						prevRow = array.get(k).row;
						con3=true;
						count++;
						break;
					}
					else if (prevCol==array.get(k).col+1 && prevRow == array.get(k).row && (con4|| j==1)){
						prevCol=array.get(k).col;
						prevRow = array.get(k).row;
						con4=true;
						count++;
						break;
					}
					else if (prevCol==array.get(k).col+1 && prevRow == array.get(k).row+1 && (con5|| j==1)){
						prevCol=array.get(k).col;
						prevRow = array.get(k).row;
						con5=true;
						count++;
						break;
					}
					else if  (prevCol==array.get(k).col && prevRow == array.get(k).row+1 && (con6|| j==1)){
						prevCol=array.get(k).col;
						prevRow = array.get(k).row;
						con6=true;
						count++;
						break;
					}
					else if  (prevCol==array.get(k).col-1 && prevRow == array.get(k).row+1 && (con7 || j==1)){
						prevCol=array.get(k).col;
						prevRow = array.get(k).row;
						con7=true;
						count++;
						break;
					}
					else if (prevCol==array.get(k).col-1 && prevRow == array.get(k).row && (con8|| j==1)){
							prevCol=array.get(k).col;
							prevRow = array.get(k).row;
							con8=true;
							count++;
							break;
					}else{
						size++;
					}
					
				}
				
			}
			
		}
		
		
		
		
		
	}

	
	
	
}

class node{
	int row;
	int col;
	
	node(){
		this.row=-1;
		this.col=-1;
	}
}