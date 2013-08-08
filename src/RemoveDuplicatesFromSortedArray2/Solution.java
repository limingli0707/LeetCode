/*
 * Question:
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A = [1,1,1,2,2,3],

Your function should return length = 5, and A is now [1,1,2,2,3].
 */
package RemoveDuplicatesFromSortedArray2;

public class Solution {
    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) return 0;
        int startPosition = 0;
        boolean isRepeated = false;
        for (int i = 1; i < A.length; i++) {
            if (A[i] != A[startPosition]) {
                isRepeated = false;
                startPosition++;
                A[startPosition] = A[i];
            } else {
                if (isRepeated == false) {
                    startPosition++;
                    A[startPosition] = A[i];
                    isRepeated = true;
                }
            }
        }
        return startPosition + 1;
    }
}
