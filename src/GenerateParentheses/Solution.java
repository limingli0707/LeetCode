/*
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:
"((()))", "(()())", "(())()", "()(())", "()()()"
 */
package GenerateParentheses;

import java.util.ArrayList;

public class Solution {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.generateParenthesis(3));
	}
	
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        char[] brackets = new char[n+n];
        generateAll (result, 0, 0, n, brackets);
         
        return result;
    }
     
    public void generateAll(ArrayList<String> result, int left, int right, int n, char[] brackets) {
        if (left == right && left == n) {
            result.add(new String(brackets));
            return;
        }
         
        if (left < n) {
        	brackets[left+right] = '(';
        	generateAll(result, left+1, right, n, brackets);
        }
         
        if (right < left) {
        	brackets[left+right] = ')';
        	generateAll(result, left, right+1, n, brackets);
        }        
    }
}