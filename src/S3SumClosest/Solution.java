/*
 * Given an array S of n integers, 
 * find three integers in S such that the sum is closest to a given number, target. 
 * Return the sum of the three integers. 
 * You may assume that each input would have exactly one solution.
 */
package S3SumClosest;

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int maxDiff = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            int p = i + 1;
            int q = num.length - 1;
            while (p < q) {
                if (num[i] + num[p] + num[q] == target) {
                    return target;
                } else {
                    if (maxDiff > (int) Math.abs(num[i] + num[p] + num[q] - target)) {
                        maxDiff = (int) Math.abs(num[i] + num[p] + num[q] - target);
                        sum = num[i] + num[p] + num[q];
                    } 
                    if (num[i] + num[p] + num[q] > target){
                        q--;
                    } else {
                        p++;
                    }
                }
            }
        }
        return sum;
    }
}