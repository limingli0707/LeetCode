/*
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
For "(()", the longest valid parentheses substring is "()", which has length = 2.
Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */
package LongestValidParentheses;

import java.util.Stack;



public class Solution {
public int longestValidParentheses(String s) {
   int i = 0;
   int maxLen = 0;
   Stack<Integer> stack = new Stack<Integer>();
   int left = 0; //deal with invalid brackets that reset counter
   while(i < s.length()){
        if(s.charAt(i) == '('){
            stack.push(i);
        }else{
           if(stack.empty()) left = i+1; //here has a invalid )
           else{
                stack.pop();
                if(stack.empty()){
                    maxLen = Math.max(maxLen,i-left+1); //after invalid ) some bracket index offset
                }else{
                    maxLen = Math.max(maxLen,i-stack.peek()); //deal with yet to process ( here
                }
           }
        }
        i++;
   }
   return maxLen;
}
}
