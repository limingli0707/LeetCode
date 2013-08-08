package S3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

//Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
public class Solution {
    public ArrayList<String> threeSum(int[] num) {
        ArrayList<String> list = new ArrayList<String>();
        HashSet<String> all = new HashSet<String>();
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            int j = i + 1;
            int z = num.length - 1;
            while (j < z) {
                if (num[i] + num[j] + num[z] == 0) {
                    String str = num[i] + ", " + num[j] + ", " + num[z];
                    all.add(str);
                    j++;
                    z--;
                } else if (num[i] + num[j] + num[z] > 0) {
                    z--;
                } else {
                    j++;
                }               
            }
        }
        
        for (String str : all) {
        	  String[] items = str.split(" ");
              // ArrayList<String> triplet = new ArrayList<String>();
               list.add(str);            
           }
        return list;
    }
}
