package SortColors;

public class Solution {
    public void sortColors(int[] A) {
        if (A == null || A.length == 0) return;
        int left = 0;
        int right = A.length - 1;
        int cur = left;
        
        while(cur <= right) {
        	if (A[cur] == 0) {
        		swap(A, left++, cur);
        		cur = (cur <= left) ? left : cur;
        	} else if (A[cur] == 2) {
        		swap(A, right--, cur);
        	} else {
        		cur++;
        	}
        }
    }
    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}