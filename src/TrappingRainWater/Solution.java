package TrappingRainWater;

public class Solution {
    public int trap(int[] A) {
        if (A == null || A.length <= 2) return 0;
        int maxIndex = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[maxIndex]) {
                maxIndex = i;
            }
        }
        int leftMax = A[0];
        int total = 0;
        for (int i = 1; i < maxIndex; i++) {
            if (A[i] < leftMax) {
                total += (leftMax - A[i]);
            } else {
                leftMax = A[i];
            }
        }
        int rightMax = A[A.length - 1];
        for (int i = A.length - 2; i > maxIndex; i--) {
            if (A[i] < rightMax) {
                total += (rightMax - A[i]);
            } else {
                rightMax = A[i];
            }
        }
        return total;
    }
}