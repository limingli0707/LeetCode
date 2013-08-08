package S4Sum;

import java.util.HashSet;
import java.util.Set;

/*
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ? b ? c ? d)
The solution set must not contain duplicate quadruplets.
 */
public class Solution {
	public static void main(String[] args) {
		int[] num = {-3,-2,-1,0,0,1,2,3};
		System.out.println(fourSum(num, 0));
	}
	
    public static ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
    	Set<ArrayList<Integer>> hset = new HashSet<ArrayList<Integer>>();
    	ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length < 4) return listAll;
        Arrays.sort(num);
        for (int i = 0; i < num.length - 3; i++) {
            for (int j = i + 1; j < num.length - 2; j++) {
                int p = j + 1;
                int q = num.length - 1;
                while (p < q) {
                    if (num[i] + num[j] + num[p] + num[q] == target) {
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(num[i]);
                        list.add(num[j]);
                        list.add(num[p]);
                        list.add(num[q]);
                        if (!hset.contains(list)) {
                        	hset.add(list);
                        	listAll.add(list);
                        }
                        p++;
                        q--;
                    } else if (num[i] + num[j] + num[p] + num[q] < target) {
                        p++;
                    } else {
                        q--;
                    }
                }
            }
        }
        return listAll;
    }
}