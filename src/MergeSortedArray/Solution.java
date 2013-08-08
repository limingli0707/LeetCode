package MergeSortedArray;

public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int pointerA = m - 1;
        int pointerB = n - 1;
        int p = m + n - 1;
        
        while (pointerA >= 0 && pointerB >= 0) {
            if (A[pointerA] > B[pointerB]) {
                A[p] = A[pointerA];
                pointerA--;
            } else {
                A[p] = B[pointerB];
                pointerB--;
            }
            p--;
        }
        
        while (pointerA >= 0) {
            A[p] = A[pointerA];
            pointerA--;
            p--;
        }
        
        while (pointerB >= 0) {
            A[p] = B[pointerB];
            pointerB--;
            p--;
        } 
    }
}