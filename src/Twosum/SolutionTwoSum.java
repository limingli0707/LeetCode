package Twosum;
/*
 * Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
 */
import java.util.HashMap;
public class SolutionTwoSum {
	 
	    
	 public static void main(String[] args){
		 int[] u ={1,2,3,4,5,6,7,8,9};
		 int[] e =twoSum(u,9);
		 System.out.println("index1="+e[0]+",index2="+e[1]);
	 }

	 public static int[] twoSum(int[] numbers, int target) {
	        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
	        for (int i = 0; i < numbers.length; ++i) {
	            Integer id = hash.get(target-numbers[i]);
	            if (id != null) {
	                int[] ret = {id+1, i+1};
	                return ret;
	            }
	            hash.put(numbers[i],i);
	        }
	        return null;
	    }
}
