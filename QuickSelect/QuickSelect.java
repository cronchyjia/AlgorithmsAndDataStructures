//Template created by Zhuoli Xiao, on Sept. 19st, 2016.
//Only used for Lab 226, 2016 Fall. 
//All Rights Reserved. 

//modified by Rich Little on Sept. 23, 2016
//modified by Rich Little on May 12, 2017
//modified by Jonas Buro on May 7, 2023

//This java file contains a template for an in-place quickSelect implementation. 
//Your task is to complete the code, and test your solution using the testing harness in main().

import java.util.Random;

public class QuickSelect {
	// invocation
	public static int QS(int[] S, int k){
        if (S.length==1)
        	return S[0];
       
        return quickSelect(0, S.length - 1, S, k - 1);
	}
	
    private static int quickSelect(int left, int right, int[] array, int k){
		if(left == right){
			return array[left];
		}
		
		int pIndex = pickRandomPivot(left, right);
		
		// Partition the array using the pivot
		pIndex = partition(left, right, array, pIndex);
		
		// Recursively call quickSelect
		// If piviot is less than, more than, or in final position compared to k
		if (k == pIndex){
			return array[k];
		}
		else if (k < pIndex){
			return quickSelect(left, pIndex-1, array, k);
		}
		else{
			return quickSelect(pIndex+1, right, array, k);
		}
    }
	
    // TODO partition an array around a pivot
    private static int partition(int left, int right, int[] array, int pIndex){
		//left is index 0
		//right is last index
		
		int pivNum = array[pIndex];
		
		// Move pivot to the end
		swap(array, pIndex, right);
		
		// Elements less than the piviot will be pushed to the left, and more than will be the right
		// When elements found are less than or equal to the piviot, index is incremented and element will be put before index
		int storage = left;
		
		for(int i = left; i < right; i++){
			if(array[i] < pivNum){
				swap(array, storage, i);
				storage++;
			}
		}
		
		// Move the pivot to the right place
		swap(array, right, storage);
		
		return storage;
	}



    // random pivot generator
	private static int pickRandomPivot(int left, int right){
		int index = 0;
		Random rand = new Random();
		index = left + rand.nextInt(right - left + 1);
		return index;
	}

	// swap element at index a with element at index b, (triangle swap)
	private static void swap(int[]array, int a, int b){
 		int tmp = array[a];
		array[a] = array[b];
		array[b] = tmp;
	}

	public static void main (String[] args){
  		int[] array1 ={12,13,17,14,21,3,4,9,21,8};  		
  		//sorted array1 = {3,4,8,9,12,13,14,17,21,21}
  		
  		int[] array2 ={14,8,22,18,6,2,15,84,13,12};
  	    //sorted array2 = {2,6,8,12,13,14,15,18,22,84}
  		
  		int[] array3 ={6,8,14,18,22,2,12,13,15,84};
  	    
  		int[] array4 = {1,2};
  		
  		int[] array5 = {1,1,1,2,2,4};
  		
  		System.out.println("Correct answer is 12 = " + "Your answer: "+QS(array1,5));
  		System.out.println("Correct answer is 21 = " + "Your answer: "+QS(array1,10));
  		System.out.println("Correct answer is 15 = " + "Your answer: "+QS(array2,7));
  		System.out.println("Correct answer is 13 = " + "Your answer: "+QS(array3,5));
  		System.out.println("Correct answer is 1 = " + "Your answer: "+QS(array4,1));
  		System.out.println("Correct answer is 2 = " + "Your answer: "+QS(array5,5));
	}
}
