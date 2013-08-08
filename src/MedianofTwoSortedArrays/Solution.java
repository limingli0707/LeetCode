/*
 * There are two sorted arrays A and B of size m and n respectively. 
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 */
package MedianofTwoSortedArrays;

public class Solution {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {2};
		int B[] = { 1, 2, 3, 4, 5 };
		double c = findMedianSortedArrays(A,B);
		System.out.println(c);
	}

	public static double findMedianSortedArrays(int A[], int B[]) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int startA = 0;
		int startB = 0;
		int tempS = 0, tempE = 0;
		double end = ((double) A.length + B.length) / 2;
		double result = 0;
		while (startA + startB < end) {
			if (startA >= A.length) {
				tempS = B[startB];
				startB++;
			} else if (startB >= B.length) {
				tempS = A[startA];
				startA++;
			} else if (A[startA] > B[startB]) {
				tempS = B[startB];
				startB++;
			} else {
				tempS = A[startA];
				startA++;
			}

		}
		if ((A.length + B.length) % 2 == 1) {
			tempE = tempS;

		} else if (startA >= A.length) {
			tempE = B[startB];

		} else if (startB >= B.length) {
			tempE = A[startA];

		} else if (A[startA] > B[startB]) {
			tempE = B[startB];

		} else {
			tempE = A[startA];

		}
		return ((double) tempS + tempE) / 2;

	}
}



