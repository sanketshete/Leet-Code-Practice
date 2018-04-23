import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
        int n=s.nextInt();
        
        String[] array = new String[n];
        
        System.out.println("Please enter the strings");

        for (int i = 0; i < array.length; i++) {
            array[i] = s.nextLine();
            if(array[i].length()>20){
            	array[i]="";
            	i--;
            }
        }
        s.nextLine();
       int n2=s.nextInt();
        int[]ans= new int[n2];
        String[] array2 = new String[n2];
        System.out.println("Please enter input strings");

        for (int i = 0; i < n2; i++) {
            array2[i] = s.nextLine();
            if(array2[i].length()>20){
            	array[i]="";
            	i--;
            }else{
            	int count=0;
            	for(int j=0;j<n;j++){
            		if(array2[i].equals(array[j])){
            			count++;
            		}
            		
            	}
            	ans[i]=count;
            }
        }
        
        for(int i=0;i<ans.length;i++){
           System.out.println(ans[i]);
        }
                
    }
}