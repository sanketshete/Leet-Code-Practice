import javax.swing.text.Position;

public class Kthlargest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] array1 = {3,2,5,0,1};
		int [] array2 = {8,10,7,6,4};
		int [] array3= new int[array1.length+array2.length];
		
		int i=0,j=0;
		
		while(i<array1.length){
			array3[i]=array1[i];
			i++;
		}
		
		while(j<array2.length){
			array3[i]=array2[j];
			i++;
			j++;
		}
		QuickSort(array3,0,array3.length-1,false,false);
		
	}

	private static void QuickSort(int[] array, int p, int r,boolean flag1,boolean flag2) {
		
		if(p<r){
			int q= partition(array,p,r);
			if(array.length%2==0){
				int pos1=array.length/2;
				int pos2=(array.length-1)/2;
				
				if(q==(pos1)){
					flag1=true;
				}
				if(q==(pos2)){
					flag2=true;
				}
				if(flag1 && flag2){
					double med = (array[pos1]+array[pos2])/2;
					System.out.println(pos1);
					System.out.println(pos2);
					System.out.println(med);
					return;
				}

			}else{
				int pos1=array.length/2;		
				if(q==(pos1)){
					flag1=true;
				}
				if(flag1){
					int med= array[pos1];
					System.out.println(med);
					return;
				}
			}

			QuickSort(array, p, q-1,flag1,flag2);
			QuickSort(array, q+1, r,flag1,flag2);
			
		}
		
	}

	private static int partition(int[] array, int p, int r) {
		
		int pivote =array[r];
		int i=p-1;
		
		for(int j=p;j<r-1;j++){
			if(array[j] <=pivote){
				i=i+1;
				int temp=array[i];
				array[i]=array[j];
				array[j]=temp;
			}
		}
		int temp=array[i+1];
		array[i+1]=array[r];
		array[r]=temp;
		return i+1;
	}

}
