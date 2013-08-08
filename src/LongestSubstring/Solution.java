/*
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters 
 * for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */
package LongestSubstring;

import java.util.HashMap;

public class Solution {
	
	public static void main(String[] args){
//		  HashMap<Character,Integer> map = new HashMap<Character, Integer>();
//		  map.put('a', 2);
//		  map.put('a', 1);
//		  int c= map.get('a');
//		  System.out.println(c);
		String a="aa";
		int c= new Solution().lengthOfLongestSubstring(a);
		System.out.println(c);
		
	}
    public  int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int max = Integer.MIN_VALUE;
        int start = 0;
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        if(s.length()==0){
            return 0;
        }
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if( map.containsKey(c)){
                for(int j=start;j<i;j++) {
                    
                    if(s.charAt(j)==c) break;
                    map.remove(s.charAt(j));
                    System.out.println("É¾³ýÁË"+s.charAt(j));
                }
                start = map.get(c)+1;
                map.put(c,i);
            } else {
                map.put(c,i);
                if( i-start+1 > max ) max = i-start+1;
            }
        }
        return max;
    }
}