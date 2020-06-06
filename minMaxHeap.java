import java.util.Arrays;
import java.io.*; 

public class minMaxHeap{
	
	private static int LEFT(int i){
		return (2*i + 1); //left child of A[i] , i is a node given
	}
	private static int RIGHT(int i){
		return (2*i + 2); //right child of A[i] , i is a node given
	}
	// Recusive Heapify down algorithm 
	private static void Heapify(int[] A , int i , int size){
		
		int left = LEFT(i);
		int right = RIGHT(i);
		int smallest =i;
		
		// get left and right child of node at index i 
		//& compare A[i] with its left and right child
		
		if(left<size && A[left] < A[i]){
			smallest = left;
		}
		if(right<size && A[right] < A[smallest]){
			smallest = right;
		}
		// swap with child having lesser value and
		// call heapify-down on the child
		if(smallest !=i){
			swap(A,i,smallest);
			Heapify(A,smallest,size);
		}
		
	}
	//swap two indices in the array
	
	private static void swap(int[] A, int i , int j){
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	
	// Function to convert max heap to min heap
	
	public static void convert(int[] A){
		// last internal node
		int i = (A.length - 2)/2;
		while(i>=0){
			Heapify(A , i--  ,A.length);
		}
	}
	
	//main
	
	public static void main(String[] args)
	{
		/*
				9

		   4		   7

		1	-2	 6	 5

		*/

		// array representing max heap
		int[] A = { 9, 4, 7, 1, -2, 6, 5 };
		minMaxHeap.convert(A);
		System.out.println(Arrays.toString(A));
	
	}
}