package Exam3;
public class Recursion {

	/*
	 * RECURSIVELY returns true if and only if integer key appears 
	 * in the array a[] starting at position start up to position end-1. 
	 */
	public static boolean exists(int[] a, int key, int start, int end) {
		if(a.length==0) {
			return false;
		}
		if(start>=end) {
			return false;
		}
		if(a[start]==key) return true;
		else return exists(a,key,start+1,end);
		
		
		 // Dummy return
	}

	/*
	 * RECURSIVELY returns the quotient after dividing a by b
	 * by successively subtracting b from a and without using the 
	 * quotient operator '/'.
	 * You may assume that all arguments are positive
	 */
	public static long div(long a, long b) {
		if(a==b) {
			return 1;
		}
		if(b==0) {
			return 0;
		}
		if(a<b) {
			return 0;
		}
		return 1+ div(a-b,b);
	}
	
	//helper
	
}





