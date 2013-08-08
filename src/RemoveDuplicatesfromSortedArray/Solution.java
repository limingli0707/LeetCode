package RemoveDuplicatesfromSortedArray;

public class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	 int ans = 0;
         for(int i = 0;i < A.length;i++)
         {
             if(i == 0 || A[i] != A[i-1])
             {
                 A[ans] = A[i];
                 ans ++;
             }
         }
         return ans;
    }
}