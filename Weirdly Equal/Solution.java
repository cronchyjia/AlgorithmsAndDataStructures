import java.io.*;
import java.util.*;

public class Solution {
    
    static boolean isWeirdEqual(int[] a, int[] b){
		if(Arrays.equals(a, b)){
			return true;
		}

		if(a.length % 2 != 0){
			return false;
		}
		
		if(b.length % 2 != 0){
			return false;
		}
		
		int lenB = b.length/2;
		int lenA = a.length/2;
		
		int[] a1 = Arrays.copyOfRange(a, 0, (lenA));	//splits a into left half
		int[] a2 = Arrays.copyOfRange(a, lenA, (a.length));	//splits a into right half
		
		int[] b1 = Arrays.copyOfRange(b, 0, (lenB));	//splits b into left half
		int[] b2 = Arrays.copyOfRange(b, lenB, (b.length));	//splits b into right half
		
		boolean a1_b1 = isWeirdEqual(a1, b1);
		boolean a2_b2 = isWeirdEqual(a2, b2);
		
		if(a1_b1 && a2_b2){
			return true;
		}
		
		else if(a1_b1 && isWeirdEqual(a1, b2)){
			return true;
		}
		
		else if(a2_b2 && isWeirdEqual(a2, b1)){
			return true;
		}
			
		return false;
	}

    public static void main(String[] args) {
        /* Read input from STDIN. Print output to STDOUT. Your class should be named Solution. 

	You should be able to compile your program with the command:
   
		javac Solution.java
	
   	To conveniently test your algorithm, you can run your solution with any of the tester input files using:
   
		java Solution inputXX.txt
	
	where XX is 00, 01, ..., 13.
	*/

   	Scanner s;
	if (args.length > 0){
		try{
			s = new Scanner(new File(args[0]));
		} catch(java.io.FileNotFoundException e){
			System.out.printf("Unable to open %s\n",args[0]);
			return;
		}
		System.out.printf("Reading input values from %s.\n",args[0]);
	}else{
		s = new Scanner(System.in);
		System.out.printf("Reading input values from stdin.\n");
	}     
  
        int n = s.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        
        for(int j = 0; j < n; j++){
            a[j] = s.nextInt();
        }
        
        for(int j = 0; j < n; j++){
            b[j] = s.nextInt();
        }
		
        System.out.println((isWeirdEqual(a, b) ? "YES" : "NO"));

    }
}
