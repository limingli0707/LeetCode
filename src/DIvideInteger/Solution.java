/*
 * Divide two integers without using multiplication, division and mod operator.
 */
package DIvideInteger;

public class Solution {
	   public int divide(int dividend1, int divisor1) {
	        if (divisor1 == 1) return dividend1;
	        if (divisor1 == -1) return -dividend1;
	        
	        long dividend = dividend1;
			long divisor = divisor1;
	    	
	   	 	boolean isPositive = false; 
			 if (dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0) {
				 isPositive = true;
			 }
			        
			dividend = Math.abs(dividend);
			divisor = Math.abs(divisor);
			 
			 if (dividend == 0) return 0;
			 int count = 1;
			 long current = divisor;
			 
			 while (current < dividend) {
				 count <<= 1;
				 current <<= 1;
			 }
			 
			 int result = 0;
			 while (current >= divisor) {
				 while (current <= dividend) {
					 dividend -= current;
					 result += count;
				 }
				 current >>= 1;
				 count >>= 1;
			 }
			if (isPositive == true) {
				return result;
			}
			return -result;
		 }
	}